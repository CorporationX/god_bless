package faang.school.godbless.BJS2_20309;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LRUCacheTest {

    LRUCache lruCache;
    ExternalDataSource dataSource;

    @BeforeEach
    void init() {
        lruCache = new LRUCache(5);
        dataSource = new ExternalDataSource();
        lruCache.setExternalDataSource(dataSource);
    }

    @Test
    @DisplayName("Testing get method")
    void getTest() {
        for (int i = 0; i < 3; i++) {
            lruCache.put(i, new Data(i, "Test data " + i, LocalDateTime.now()));
        }
        assertEquals(3, lruCache.getSize());

        Data data = lruCache.get(10);
        assertEquals(10, data.getId());
        assertTrue(data.getValue().startsWith("New Data from external DataSource received: "));
        assertEquals(4, lruCache.getSize());
    }

    @Test
    @DisplayName("Testing put and get methods with printing result")
    void testPutAndGetDataWithPrintingCash() throws InterruptedException {
        lruCache.put(1, new Data(1, "Test Data 1", LocalDateTime.now()));
        lruCache.put(2, new Data(2, "Test Data 2", LocalDateTime.now()));
        lruCache.put(3, new Data(3, "Test Data 3", LocalDateTime.now()));
        lruCache.put(4, new Data(4, "Test Data 4", LocalDateTime.now()));
        lruCache.put(5, new Data(5, "Test Data 5", LocalDateTime.now()));

        lruCache.print();

        Thread.sleep(1000);
        lruCache.get(45);

        Thread.sleep(1000);
        lruCache.get(4);

        Thread.sleep(1000);
        lruCache.get(2);

        Thread.sleep(1000);
        lruCache.get(15);

        lruCache.print();
        System.out.println("==========");

        Thread.sleep(5000);
        lruCache.get(15);

        lruCache.print();

        System.out.println("===========");
        Thread.sleep(1000);
        lruCache.put(4, new Data(4, "New data on id=4 test", LocalDateTime.now()));
        lruCache.print();
    }

    @Test
    @DisplayName("Testing that cache doesn't fill more than CACHE_SIZE")
    void putTest() {
        for (int i = 0; i < 10; i++) {
            lruCache.put(i, new Data(i, "Test Data " + i, LocalDateTime.now()));
        }

        assertEquals(5, lruCache.getSize());
    }
}