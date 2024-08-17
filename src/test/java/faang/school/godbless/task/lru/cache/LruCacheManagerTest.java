package faang.school.godbless.task.lru.cache;

import faang.school.godbless.task.hashmap.lru.cache.Data;
import faang.school.godbless.task.hashmap.lru.cache.DataStructure;
import faang.school.godbless.task.hashmap.lru.cache.LruCacheManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LruCacheManagerTest {
    private final Data data1 = new Data(1L, "A");
    private final Data data2 = new Data(2L, "B");
    private final Data data3 = new Data(3L, "C");
    private final Data data4 = new Data(4L, "D");
    private final Data data5 = new Data(5L, "E");
    private final Data data6 = new Data(6L, "F");
    private final Data data7 = new Data(7L, "G");
    private final Data data8 = new Data(8L, "H");
    private final Data data9 = new Data(9L, "I");
    private final Data data10 = new Data(10L, "J");
    private final Data data11 = new Data(11L, "K");
    private final Data data12 = new Data(12L, "L");

    private List<Data> dataList;
    private LruCacheManager lruCacheManager;

    @BeforeEach
    void setUp() {
        lruCacheManager = new LruCacheManager(new DataStructure(new HashMap<>()));
        dataList = List.of(data1, data2, data3, data4, data5, data6,
                data7, data8, data9, data10, data11, data12);
        dataList.forEach(data -> {
            lruCacheManager.addNewDataIntoDataStructure(data);
        });

    }

    @Test
    @DisplayName("Add new data into data structure")
    void testAddNewDataIntoDataStructure() {
        Data dataExpected = new Data(13L, "X");
        lruCacheManager.addNewDataIntoDataStructure(dataExpected);
        Data dataActual = lruCacheManager.findDataById(dataExpected.getId());
        assertEquals(dataExpected, dataActual);
    }

    @Test
    @DisplayName("Find data by id")
    void testFindDataById() {
        assertEquals(data1, lruCacheManager.findDataById(data1.getId()));
    }

    @Test
    @DisplayName("Print all data in cache")
    void testPrintAllDataInCache() {
        addDataToCache();
        lruCacheManager.printAllDataInCache();
    }

    @Test
    @DisplayName("Test for deleting oldest data in the cache")
    void testDeleteOldestData() {
        addDataToCache();
        try {
            lruCacheManager.printAllDataInCache();
            System.out.println("\nFind: " + data8);
            lruCacheManager.findDataById(8L);
            Thread.sleep(1000);
            lruCacheManager.printAllDataInCache();
            System.out.println("\nFind: " + data2);
            lruCacheManager.findDataById(2L);
            Thread.sleep(1000);
            lruCacheManager.printAllDataInCache();
            System.out.println("\nFind: " + data2);
            lruCacheManager.findDataById(2L);
            Thread.sleep(1000);
            lruCacheManager.printAllDataInCache();
            System.out.println("\nFind: " + data9);
            lruCacheManager.findDataById(9L);
            Thread.sleep(1000);
            lruCacheManager.printAllDataInCache();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @DisplayName("Add data to cache with delay")
    void addDataToCache() {
        try {
            lruCacheManager.findDataById(8L);
            Thread.sleep(1000);
            lruCacheManager.findDataById(9L);
            Thread.sleep(1000);
            lruCacheManager.findDataById(10L);
            Thread.sleep(1000);
            lruCacheManager.findDataById(11L);
            Thread.sleep(1000);
            lruCacheManager.findDataById(12L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
