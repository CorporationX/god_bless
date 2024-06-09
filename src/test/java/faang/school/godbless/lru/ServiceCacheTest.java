package faang.school.godbless.lru;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceCacheTest {
    private ServiceCache serviceCache;
    Map<Integer, Data> cacheRequest = new HashMap<>();

    @BeforeEach
    void setUp() {
        cacheRequest.put(1, new Data(1, 1));
        cacheRequest.put(2, new Data(2, 2));
        cacheRequest.put(3, new Data(3, 3));
        cacheRequest.put(4, new Data(4, 4));
        cacheRequest.put(5, new Data(5, 5));
        serviceCache = new ServiceCache(cacheRequest);
    }

    @Test
    void testAddNewData_Positive() {
        var addData = new Data(7, 7);
        var expected = cacheRequest;
        expected.remove(new Data(1, 1));
        expected.put(addData.getID(), addData);
        serviceCache.addNewData(addData);
        assertEquals(expected, cacheRequest);
    }

    @Test
    void testSearchData_SearchInCachePositive() {
        var expected = new Data(3, 3);
        assertEquals(expected, serviceCache.searchData(3));
    }

    @Test
    void testSearchData_SearchInDBPositive() {
        var expected = new Data(1, 1);
        serviceCache.addNewData(new Data(7, 7));
        assertEquals(expected, serviceCache.searchData(1));
    }

    @Test
    void testServiceCache_MapNullOrEmptyNegative() {
        Map<Integer, Data> emptyMap = new HashMap<>();
        Map<Integer, Data> nullMap = null;
        assertThrows(IllegalArgumentException.class, () -> serviceCache = new ServiceCache(emptyMap));
        assertThrows(IllegalArgumentException.class, () -> serviceCache = new ServiceCache(nullMap));
    }

    @Test
    void testAddNewData_DataIsNullNegative() {
        Data nullData = null;
        assertThrows(IllegalArgumentException.class, () -> serviceCache.addNewData(nullData));
    }

    @Test
    void testSearchData_MissingFromDBNegative() {
        assertThrows(RuntimeException.class, () -> serviceCache.searchData(210));
    }
}