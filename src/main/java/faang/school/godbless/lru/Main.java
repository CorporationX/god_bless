package faang.school.godbless.lru;

import faang.school.godbless.lru.models.Data;

import java.util.HashMap;

import static faang.school.godbless.lru.services.DataService.*;

public class Main {

    public static HashMap<Integer, Data> cacheLRU = new HashMap<>();

    public static void main(String[] args) {
        Data data = new Data(0, "Test");
        Data data1 = new Data(1, "Test1");
        Data data2 = new Data(2, "Test2");
        Data data3 = new Data(3, "Test3");

        addNewDataToCache(cacheLRU, data);
        addNewDataToCache(cacheLRU, data1);
        addNewDataToCache(cacheLRU, data2);
        addNewDataToCache(cacheLRU, data3);
        printCurrentCache(cacheLRU);
        System.out.println();

        getDataFromCacheById(cacheLRU, 0);
        printCurrentCache(cacheLRU);
        System.out.println();

        Data data4 = new Data(4, "Test4");
        addNewDataToCache(cacheLRU, data4);
        printCurrentCache(cacheLRU);
        System.out.println();

        Data data5 = new Data(5, "Test5");
        addNewDataToCache(cacheLRU, data5);
        printCurrentCache(cacheLRU);
    }
}
