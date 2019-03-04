package org.rabbit.service;

import org.rabbit.module.DashboardData;

import java.util.List;
import java.util.Map;

public interface DashboardTemplate<T> {

    T fromMap(Map<String, String> map);

    List<String> getHeader();
    List<String> getDimensions();
    List<String> getIndexes();

    DashboardData getAllLoad(T data);

}
