package lru.cache.test;

import lru.cache.Data;
import lru.cache.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CacheTest {
    private Main cache;
    @BeforeEach
    void setUp() {
        cache = new Main();
    }

    @Test
    @DisplayName("Testind addToBase method")
    void cacheTest_addToBase() {
        Data data = new Data("test", LocalDateTime.now());

        cache.addDateToBase(data);

        assertTrue(cache.getDataBase().containsKey(data.getId()));
    }

    @Test
    @DisplayName("Testing addToBase method wtih data already in databse")
    void cacheTest_addToBaseWithDataInBase() {
        Data data = new Data("test", LocalDateTime.now());
        cache.addDateToBase(data);

        cache.addDateToBase(data);

        assertEquals(1, cache.getDataBase().size());
    }

    @Test
    @DisplayName("Testing addToBase method with null arguments")
    void cacheTest_addToBaseWithNullArguments() {
        assertThrows(NullPointerException.class, () -> cache.addDateToBase(null));
    }

    @Test
    @DisplayName("Testing getData method from base")
    void cacheTest_getDataFromBase() {
        Data data = new Data("test", LocalDateTime.now());
        cache.addDateToBase(data);

        var result = cache.getData(data.getId());

        assertEquals(data, result);
    }

    @Test
    @DisplayName("Testing getData method from cache")
    void cacheTest_getDataFromCache() {
        Data data = new Data("test", LocalDateTime.now());
        cache.addDateToBase(data);
        cache.getData(data.getId());
        long expected = data.getTimestamp().getLong(ChronoField.MICRO_OF_DAY);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        var result = cache.getData(data.getId());
        System.out.println(result.getTimestamp());

        assertAll(
                () -> assertEquals(data.getId(), result.getId()),
                () -> assertEquals(data.getValue(), result.getValue()),
                () -> assertNotEquals(expected, result.getTimestamp().getLong(ChronoField.MICRO_OF_DAY))
        );
    }

    @Test
    @DisplayName("Testing getData method with id not in base")
    void cacheTest_getDataWithIdNotInBase() {
        assertThrows(NoSuchElementException.class, () -> cache.getData(5));
    }

    @Test
    @DisplayName("Testing rewrite cache")
    void cacheTest_rewriteCache() {
        Data data = new Data("test", LocalDateTime.now());
        cache.addDateToBase(data);
        for (int i = 0; i <= Main.CACHE_SIZE; i++) {
            cache.addDateToBase(new Data("test", LocalDateTime.now()));
        }

        for (int i = data.getId(); i <= cache.getDataBase().size() + data.getId() - 1; i++) {
            cache.getData(i);
        }
        cache.getData(data.getId() + 1);

        assertFalse(cache.getCache().containsKey(data.getId()));
    }
}
