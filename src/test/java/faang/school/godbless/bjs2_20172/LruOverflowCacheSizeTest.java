package faang.school.godbless.bjs2_20172;

import faang.school.godbless.bjs2_20172.lru_cache_custom_linkedhashmap.LruCustomLinkedHashMap;
import faang.school.godbless.bjs2_20172.lru_cache_hashmap.LruHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LruOverflowCacheSizeTest {
//    private LruHashMap main;
    private LruCustomLinkedHashMap main;

    @BeforeEach
    public void setUp() throws InterruptedException {
//        main = new LruHashMap();
        main = new LruCustomLinkedHashMap();
        main.addData(new Data(1, "1"));
        Thread.sleep(10);
        main.addData(new Data(2, "2"));
        Thread.sleep(10);
        main.addData(new Data(3, "3"));
        Thread.sleep(10);
        main.addData(new Data(4, "4"));
        Thread.sleep(10);
        main.addData(new Data(4, "4"));
        Thread.sleep(10);
        main.addData(new Data(5, "5"));
        Thread.sleep(10);

        main.getData(1);
        Thread.sleep(10);
        main.getData(2);
        Thread.sleep(10);
        main.getData(3);
        Thread.sleep(10);
    }

    private void execute(int first, int a, int b, int c, int second, int x, int y, int z) throws InterruptedException {
        main.getData(first);
        Thread.sleep(10);
        var cacheFirst = main.getCache();
        var tail = cacheFirst.get(a);
        var middle = cacheFirst.get(b);
        var head = cacheFirst.get(c);
        assertTrue(head.getTimestamp().isAfter(middle.getTimestamp()));
        assertTrue(middle.getTimestamp().isAfter(tail.getTimestamp()));

        main.getData(second);
        Thread.sleep(10);
        var cacheSecond = main.getCache();
        var tail2 = cacheSecond.get(x);
        var middle2 = cacheSecond.get(y);
        var head2 = cacheSecond.get(z);
        assertTrue(head2.getTimestamp().isAfter(middle2.getTimestamp()));
        assertTrue(middle2.getTimestamp().isAfter(tail2.getTimestamp()));
    }

    // 1,2,3 + 4 -> 2,3,4 + 5 -> 3,4,5
    @Test
    void testGetData_FromCacheNull_ButFromStorage_OverflowCacheSize_Case1() throws InterruptedException {
        execute(4, 2, 3, 4, 5, 3, 4, 5);
    }

    // 1,2,3 + 1 -> 2,3,1 + 1 -> 2,3,1
    @Test
    void testGetData_FromCacheNull_ButFromStorage_OverflowCacheSize_Case2() throws InterruptedException {
        execute(1, 2, 3, 1, 1, 2, 3, 1);
    }

    // 1,2,3 + 1 -> 2,3,1 + 4 -> 3,1,4
    @Test
    void testGetData_FromCacheNull_ButFromStorage_OverflowCacheSize_Case3() throws InterruptedException {
        execute(1, 2, 3, 1, 4, 3, 1, 4);
    }

    // 1,2,3 + 2 -> 1,3,2 + 2 -> 1,3,2
    @Test
    void testGetData_FromCacheNull_ButFromStorage_OverflowCacheSize_Case4() throws InterruptedException {
        execute(2, 1, 3, 2, 2, 1, 3, 2);
    }

    // 1,2,3 + 2 -> 1,3,2 + 4 -> 3,2,4
    @Test
    void testGetData_FromCacheNull_ButFromStorage_OverflowCacheSize_Case5() throws InterruptedException {
        execute(2, 1, 3, 2, 4, 3, 2, 4);
    }

    // 1,2,3 + 3 -> 1,2,3 + 3 -> 1,2,3
    @Test
    void testGetData_FromCacheNull_ButFromStorage_OverflowCacheSize_Case6() throws InterruptedException {
        execute(3, 1, 2, 3, 3, 1, 2, 3);
    }

    // 1,2,3 + 3 -> 1,2,3 + 4 -> 2,3,4
    @Test
    void testGetData_FromCacheNull_ButFromStorage_OverflowCacheSize_Case7() throws InterruptedException {
        execute(3, 1, 2, 3, 4, 2, 3, 4);
    }

    // 1,2,3 + 2 -> 1,3,2 + 3 -> 1,2,3
    @Test
    void testGetData_FromCacheNull_ButFromStorage_OverflowCacheSize_Case8() throws InterruptedException {
        execute(2, 1, 3, 2, 3, 1, 2, 3);
    }

    // 1,2,3 + 1 -> 2,3,1 + 2 -> 3,1,2
    @Test
    void testGetData_FromCacheNull_ButFromStorage_OverflowCacheSize_Case9() throws InterruptedException {
        execute(1, 2, 3, 1, 2, 3, 1, 2);
    }
}
