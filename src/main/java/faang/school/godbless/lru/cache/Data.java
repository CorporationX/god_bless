package faang.school.godbless.lru.cache;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    private int id;
    private String value;
    private String timestamp;
    private List<Data> dataSrtucture = new ArrayList<>();
    private Map<Integer, Data> cache = new HashMap<>();
    private final int CACHE_SIZE = 32;

    protected void addData() {
        // add new Data obj to data structure;
    }

    protected void getDataById() {
        // get Data obj from data structure by id;
        // if cache contains data ->
        //  1. return data
        //  2. update its timestamp
        // if cache doesn't have data ->
        //  1. get data from data structure
        //  2. add data to cache
        //  3. update its timestamp
    }

    protected void removeDataFromCache() {
        // if cache size exceeds CACHE_SIZE
        // remove the oldest data (with the lowest timestamp)
        // before adding new Data to cache
    }

    protected void getCacheCurrentState() {
        // output info about current cache state
        // Using Map Entry
        // output id and Data obj values and timestamps
    }
}