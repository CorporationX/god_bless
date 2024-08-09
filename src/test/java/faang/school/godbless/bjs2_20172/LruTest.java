package faang.school.godbless.bjs2_20172;

import faang.school.godbless.bjs2_20172.lru_cache_custom_linkedhashmap.LruCustomLinkedHashMap;
import faang.school.godbless.bjs2_20172.lru_cache_hashmap.LruHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LruTest {
//    private LruHashMap main;
    private LruCustomLinkedHashMap main;

    @BeforeEach
    public void setUp() {
//        main = new LruHashMap();
        main = new LruCustomLinkedHashMap();
    }

    @Test
    void testAddData_Success() {
        var firstInsert = new Data(1, "first insert");
        main.addData(firstInsert);
        var addedFirstInsert = main.getDataById(1);
        assertNotNull(addedFirstInsert);
        assertEquals(addedFirstInsert.getId(), 1);
        assertEquals(addedFirstInsert.getValue(), "first insert");

        var secondInsert = new Data(1, "second insert");
        main.addData(secondInsert);
        var addedSecondInsert = main.getDataById(1);
        assertNotNull(addedSecondInsert);
        assertEquals(addedSecondInsert.getId(), 1);
        assertEquals(addedSecondInsert.getValue(), "second insert");
    }

    @Test
    void testGetData_FromCacheNull() {
        var data = main.getData(1);
        assertNull(data);
    }

    @Test
    void testGetData_FromCacheNull_ButFromStorage() throws InterruptedException {
        var dataToAdd = new Data(1, "1");
        var timestampBefore = dataToAdd.getTimestamp();
        main.addData(new Data(1, "1"));

        Thread.sleep(100);

        var data = main.getData(1);
        var timestampAfter = data.getTimestamp();
        assertFalse(timestampBefore.equals(timestampAfter));
        assertEquals(data.getId(), 1);
        assertEquals(data.getValue(), "1");

        var dataFromStorage = main.getStorage().get(1);
        assertTrue(timestampAfter.equals(dataFromStorage.getTimestamp()));
        var dataFromCache = main.getCache().get(1);
        assertTrue(timestampAfter.equals(dataFromCache.getTimestamp()));
    }

    @Test
    void testGetData_FromCacheNotNull_ChangedTimestamp() throws InterruptedException {
        var data = new Data(1, "1");
        var timestampBefore = data.getTimestamp();
        main.addDataToCache(data);

        Thread.sleep(100);

        var foundData = main.getData(1);
        var timestampAfter = foundData.getTimestamp();
        assertFalse(timestampBefore.equals(timestampAfter));
        assertEquals(1, foundData.getId());
        assertEquals("1", foundData.getValue());
        assertNotEquals(timestampBefore, timestampAfter);

        var cache = main.getCache();
        var dataFromCache = cache.get(1);
        assertNotNull(dataFromCache);
        assertEquals(foundData.getId(), dataFromCache.getId());
        assertEquals(foundData.getValue(), dataFromCache.getValue());
        assertTrue(foundData.getTimestamp().equals(dataFromCache.getTimestamp()));
    }
}