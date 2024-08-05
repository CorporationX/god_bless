import hashmap.group.Id;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IdTest {
    @Test
    @DisplayName("Test create Id with null arguments")
    void idTest_createWithNullArguments() {
        assertThrows(NullPointerException.class, () -> new Id(null, 2));
    }
}
