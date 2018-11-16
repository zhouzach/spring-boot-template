package org.rabbit.service;

import org.rabbit.module.FullData;

import java.util.List;
import java.util.Map;

public interface ChartTemplate<T> {


    T fromMap(Map<String, String> map);

    List<String> getHeader();
    List<String> getDimensions();
    List<String> getIndexes();


    //    @Override
    //    public List<String> getExport(BaseData.BaseActivityData data){
    //        ArrayList<String> list = new ArrayList<>();
    //        FullData getAll = this.getAllLoad(data);
    //        List<List<String>> getLoad = getAll.getLoad();
    //        ArrayList<String> description = new ArrayList<>();
    //        for (int i=1;i<getLoad.size();i++){
    //            description.add(getLoad.get(i).get(2));
    //        }
    //        String descriptions = StringUtils.strip(description.toString(),"[]");
    //        String couponCount = getLoad.get(1).get(5);
    //        list.add(descriptions);
    //        list.add(couponCount);
    //        return list;
    //    }

    FullData getAllLoad(T data);



}
