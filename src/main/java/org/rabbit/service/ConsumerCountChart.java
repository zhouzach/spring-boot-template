package org.rabbit.service;

import org.rabbit.module.FullData;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class ConsumerCountChart implements  ChartTemplate<String> {


    @Override
    public String fromMap(Map<String, String> map){

        return "";
    }

    @Override
    public List<String> getHeader() {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("timestamp");
        objects.add("sum");
        objects.add("goldSum");
        objects.add("jadeSum");
        objects.add("silverSum");
        objects.add("northChina");
        objects.add("eastChina");
        objects.add("southChina");
        objects.add("westernRegion");
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
     *   private Integer goldSum;
     *   private Integer jadeSum;
     *   private Integer silverSum;
     *   private Integer northChina;
     *   private Integer eastChina;
     *   private Integer southChina;
     *   private Integer westernRegion;
     * @return
     */
    @Override
    public List<String> getIndexes() {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("sum");
        objects.add("goldSum");
        objects.add("jadeSum");
        objects.add("silverSum");
        objects.add("northChina");
        objects.add("eastChina");
        objects.add("southChina");
        objects.add("westernRegion");

        return objects;
    }

    @Override
    public FullData getAllLoad(String str) {


        FullData fullData = new FullData();
        return fullData;
    }


}
