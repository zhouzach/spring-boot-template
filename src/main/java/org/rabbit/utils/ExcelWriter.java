package org.rabbit.utils;

import lombok.val;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.rabbit.module.Book;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExcelWriter {


    public void write2OutputStream(List<String> headerList, List<Map<String, Object>> data,
                                   Workbook workbook, String sheetName,
                                   OutputStream outputStream) {
        Sheet sheet = workbook.createSheet(sheetName);

        createHeaderRow(headerList, sheet);

        int rowCount = 0;
        for (Map<String, Object> map : data) {
            Row row = sheet.createRow(++rowCount);
            setCellValue(map, row);
        }

        try {
            workbook.write(outputStream);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    private void setCellValue(Map<String, Object> map, Row row) {
        Object[] keys = map.keySet().toArray();
        for (int i = 0; i < keys.length; i++) {
            row.createCell(i)
                    .setCellValue(String.valueOf(map.get(keys[i])));
        }
    }


    private CellStyle createHeaderStyle(Sheet sheet) {
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();

        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);

        cellStyle.setFont(font);

        return cellStyle;
    }

    private void createHeaderRow(List<String> headerList, Sheet sheet) {

        Row row = sheet.createRow(0);
        CellStyle cellStyle = createHeaderStyle(sheet);

        for (int i = 0; i < headerList.size(); i++) {
            Cell cellTitle = row.createCell(i);
            cellTitle.setCellStyle(cellStyle);
            cellTitle.setCellValue(headerList.get(i));
        }
    }

    private Workbook getWorkbook(String excelFilePath) {
        Workbook workbook;

        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    public List<Book> getListBook() {
        Book book1 = new Book("Head First Java", "Kathy Serria", 79);
        Book book2 = new Book("Effective Java", "Joshua Bloch", 36);
        Book book3 = new Book("Clean Code", "Robert Martin", 42);
        Book book4 = new Book("Thinking in Java", "Bruce Eckel", 35);

        List<Book> listBook = Arrays.asList(book1, book2, book3, book4);

        return listBook;
    }

    public static void main(String[] args) {
        ExcelWriter excelWriter = new ExcelWriter();

        List<Book> listBook = excelWriter.getListBook();
        val books = listBook.stream().map(ObjectHelper::toMap).collect(Collectors.toList());
        String excelFilePath = "JavaBooks3.xlsx";

        List<String> header = Arrays.asList("title", "author", "price");

        Workbook workbook = new XSSFWorkbook();

        try {
            OutputStream outputStream = new FileOutputStream(excelFilePath);
            excelWriter.write2OutputStream(header, books, workbook, "book1", outputStream);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}
