package index.elk.test;

import index.elk.Query;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueryTest {
    @Test
    @DisplayName("Testing create query with null arguments")
    void queryTest_createQueryWithNullArguments() {
        String content = "test";
        LocalDateTime timestamp = LocalDateTime.now();
        assertAll(
                () -> assertThrows(
                        NullPointerException.class, () -> new Query(null, timestamp)
                ),
                () -> assertThrows(
                        NullPointerException.class, () -> new Query(content, null)
                )
        );
    }
}
