package lru_cache;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    private static final Map<Integer, Data> dataMap = new HashMap<>();
    private final static LinkedHashMap<Integer, Data> cache = new LinkedHashMap<>();

    private static final int CACHE_SIZE = 5;

    public static void main(String[] args) {

    }

    public static Data getDataById(int dataId){

    }

    public static void addToCache(Data data){

    }

    public static void addData(Data data) {
        dataMap.put(data.getId(), data);
    }

}
