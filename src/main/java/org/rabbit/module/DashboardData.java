package org.rabbit.module;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class DashboardData {
    private List<List<String>> load;
    private Map<String, Object> totals;

}



