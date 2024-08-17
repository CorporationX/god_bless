package lru.cache.test;

import lru.cache.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataTest {
    @Test
    @DisplayName("Create data with null arguments")
    void dataTest_createDataWithNullArguments() {
        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> new Data(null, LocalDateTime.now())),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> new Data("aboba", null)),
                () -> assertDoesNotThrow(
                        () -> new Data("aboba", LocalDateTime.now())));
    }
}
