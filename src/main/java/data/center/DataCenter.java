package data.center;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class DataCenter {
    private final Map<Server, Double> serverLoads = new HashMap<>();
}
