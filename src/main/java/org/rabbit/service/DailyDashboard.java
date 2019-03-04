package org.rabbit.service;

import org.rabbit.module.DashboardData;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class DailyDashboard implements DashboardTemplate<String> {


    @Override
    public String fromMap(Map<String, String> map){

        return "";
    }

    @Override
    public List<String> getHeader() {
        ArrayList<String> objects = new ArrayList<>();

        return objects;
    }

    @Override
    public List<String> getDimensions() {
        ArrayList<String> objects = new ArrayList<>();

        objects.add("timestamp");
        return objects;
    }

    /**
     *   private Long timestamp;
     *   private Integer sum;
     *
     * @return
     */
    @Override
    public List<String> getIndexes() {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("sum");


        return objects;
    }

    @Override
    public DashboardData getAllLoad(String str) {


        DashboardData dashboardData = new DashboardData();
        return dashboardData;
    }


}
