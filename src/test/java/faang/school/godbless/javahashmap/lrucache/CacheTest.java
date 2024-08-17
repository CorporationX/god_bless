package faang.school.godbless.javahashmap.lrucache;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CacheTest {

    private static Data DATA_1 = new Data(1, "value1");
    private static Data DATA_2 = new Data(2, "value2");
    private static Data DATA_3 = new Data(3, "value3");
    private static Data DATA_4 = new Data(4, "value4");
    private static Data DATA_5 = new Data(5, "value5");

    @Test
    void testAdd_One() {
        Cache cache = new Cache();

        cache.add(DATA_1);

        Map<Integer, Data> idToDataMap = cache.getIdToDataMap();
        assertEquals(1, idToDataMap.size());
        Data dataFromIdToDataMap = idToDataMap.get(1);
        assertEquals(DATA_1.getId(), dataFromIdToDataMap.getId());

        Map<Pair<Integer, Long>, Data> timeToDataMap = cache.getTimeToDataMap();
        assertEquals(1, timeToDataMap.size());
        Data dataFromTimeToDataMap = timeToDataMap.get(new Pair<>(1, dataFromIdToDataMap.getTimestamp()));
        assertEquals(DATA_1.getId(), dataFromTimeToDataMap.getId());
    }

    @Test
    void testAdd_Five() {
        Cache cache = new Cache();

        cache.add(DATA_1);
        cache.add(DATA_2);
        cache.add(DATA_3);
        cache.add(DATA_4);
        cache.add(DATA_5);

        Map<Integer, Data> idToDataMap = cache.getIdToDataMap();
        assertEquals(4, idToDataMap.size());
        assertNull(idToDataMap.get(1));
        assertEquals(DATA_2, idToDataMap.get(2));
        assertEquals(DATA_3, idToDataMap.get(3));
        assertEquals(DATA_4, idToDataMap.get(4));
        assertEquals(DATA_5, idToDataMap.get(5));

        Map<Pair<Integer, Long>, Data> timeToDataMap = cache.getTimeToDataMap();
        assertEquals(4, timeToDataMap.size());
        assertNull(timeToDataMap.get(new Pair<>(1, DATA_1.getTimestamp())));
        assertEquals(DATA_2, timeToDataMap.get(new Pair<>(2, DATA_2.getTimestamp())));
        assertEquals(DATA_3, timeToDataMap.get(new Pair<>(3, DATA_3.getTimestamp())));
        assertEquals(DATA_4, timeToDataMap.get(new Pair<>(4, DATA_4.getTimestamp())));
        assertEquals(DATA_5, timeToDataMap.get(new Pair<>(5, DATA_5.getTimestamp())));
    }

    @Test
    void testGet() {
        Cache cache = new Cache();

        cache.add(DATA_1);
        cache.add(DATA_2);
        cache.add(DATA_3);
        cache.add(DATA_4);       //                          начало ->       <- конец
        cache.add(DATA_5);       // вылетел 1, добавился 5,  осталось 2-3-4-5

        DATA_1 = cache.get(1);   // вылетел 2, добавился 1,  осталось 3-4-5-1
        DATA_1 = cache.get(1);   // ничего не изменилось
        DATA_4 = cache.get(4);   // 4 перешёл в начало    ,  осталось 3-5-1-4
        DATA_3 = cache.get(3);   // 3 перешёл в начало    ,  осталось 5-1-4-3

        Map<Integer, Data> idToDataMap = cache.getIdToDataMap();
        assertEquals(4, idToDataMap.size());
        assertEquals(DATA_1, idToDataMap.get(1));
        assertNull(idToDataMap.get(2));
        assertEquals(DATA_3, idToDataMap.get(3));
        assertEquals(DATA_4, idToDataMap.get(4));
        assertEquals(DATA_5, idToDataMap.get(5));

        Map<Pair<Integer, Long>, Data> timeToDataMap = cache.getTimeToDataMap();
        assertEquals(4, timeToDataMap.size());

        Iterator<Map.Entry<Pair<Integer, Long>, Data>> iterator = timeToDataMap.entrySet().iterator();
        // берём от самого ранне-положенному к самому поздне-положенному
        assertEquals(DATA_5, iterator.next().getValue());
        assertEquals(DATA_1, iterator.next().getValue());
        assertEquals(DATA_4, iterator.next().getValue());
        assertEquals(DATA_3, iterator.next().getValue());
    }
}