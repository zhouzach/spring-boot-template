package org.rabbit.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.rabbit.module.Book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectHelper {

    public static Map<String, Object> toMap(Object object) {
        ObjectMapper oMapper = new ObjectMapper();
        return oMapper.convertValue(object, Map.class);
    }

    public static void main(String[] args){

        ExcelWriter excelWriter = new ExcelWriter();
        List<Book> listBook = excelWriter.getListBook();
        val books = listBook.stream().map(ObjectHelper::toMap).collect(Collectors.toList());
        books.forEach(System.out::println);

    }


}
