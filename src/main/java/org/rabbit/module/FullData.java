package org.rabbit.module;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class FullData {
    private List<List<String>> load;
    private Map<String, Object> totals;

}



