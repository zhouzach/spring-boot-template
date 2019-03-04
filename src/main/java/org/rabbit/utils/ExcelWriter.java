package org.rabbit.utils;

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


    public void write2OutputStream(
            Workbook workbook, String sheetName,
            Integer x, Integer y,
            List<String> headerList, List<Map<String, Object>> data,
            OutputStream outputStream) {
        Sheet sheet = workbook.createSheet(sheetName);

        createHeaderRow(x, y, headerList, sheet);

        for (Map<String, Object> map : data) {
            Row row = sheet.createRow(++x);
            setCellValue(y, map, row);
        }

        try {
            workbook.write(outputStream);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    private void setCellValue(Integer y, Map<String, Object> map, Row row) {
        Object[] keys = map.keySet().toArray();
        for (int k = 0; k < keys.length; k++, y++) {
            row.createCell(y)
                    .setCellValue(String.valueOf(map.get(keys[k])));
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

    private void createHeaderRow(int x, int y, List<String> headerList, Sheet sheet) {

        Row row = sheet.createRow(x);
        CellStyle cellStyle = createHeaderStyle(sheet);

        for (int k = 0; k < headerList.size(); y++, k++) {
            Cell cellTitle = row.createCell(y);
            cellTitle.setCellStyle(cellStyle);
            cellTitle.setCellValue(headerList.get(k));
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
        Book book1 = new Book();
        book1.setTitle("Head First Java");
        book1.setAuthor("Kathy Serria");
        book1.setPrice(79);
        Book book2 = new Book();
        book2.setTitle("Effective Java");
        book2.setAuthor("Joshua Bloch");
        book2.setPrice(36);

        List<Book> listBook = Arrays.asList(book1, book2);

        return listBook;
    }

    public static void main(String[] args) {
        ExcelWriter excelWriter = new ExcelWriter();

        List<Book> listBook = excelWriter.getListBook();
        List<Map<String, Object>> data = listBook.stream().map(ObjectHelper::toMap).collect(Collectors.toList());
        String filename = "JavaBooks.xlsx";

        List<String> header = Arrays.asList("title", "author", "price");

        Workbook workbook = new XSSFWorkbook();

        try {
            OutputStream outputStream = new FileOutputStream(filename);
            excelWriter.write2OutputStream(workbook, "sheet1", 5, 5, header, data, outputStream);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}
