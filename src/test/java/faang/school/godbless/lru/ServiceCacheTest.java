package faang.school.godbless.lru;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceCacheTest {
    private ServiceCache serviceCache;
    private Map<Integer, Data> cacheRequest = new HashMap<>();

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
        var data = new Data(7, 7);
        var expected = new HashMap<>(cacheRequest);
        expected.remove(1);
        expected.put(data.getID(), data);
        serviceCache.addNewData(data);
        assertEquals(expected, cacheRequest);
    }

    @Test
    void testSearchData_intoCachePositive() {
        var expected = new Data(1, 1);
        assertEquals(expected, serviceCache.searchData(1));
    }

    @Test
    void testSearchData_intoDBPositive() {
        var expected = new Data(1, 1);
        serviceCache.addNewData(new Data(9, 9));
        assertEquals(expected, serviceCache.searchData(1));
    }

    @Test
    void testServiceCache_MapNullOrEmptyNegative() {
        Map<Integer, Data> nullMap = null;
        Map<Integer, Data> emptyMap = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> serviceCache = new ServiceCache(nullMap));
        assertThrows(IllegalArgumentException.class, () -> serviceCache = new ServiceCache(emptyMap));
    }

    @Test
    void testAddNewData_DataIsNullNegative() {
        Data data = null;
        assertThrows(IllegalArgumentException.class, () -> serviceCache.addNewData(data));
    }

    @Test
    void testSearchData_NotExistentElementNegative() {
        assertThrows(RuntimeException.class, () -> serviceCache.searchData(210));
    }
}