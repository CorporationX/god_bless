package exception.catching.test;

import exceptions.catching.StreamEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StreamEventTest {
    @Test
    @DisplayName("Create StreamEvent with null arguments")
    void streamEventTest_createEventWithNullArguments() {
        assertAll(
                () -> assertThrows(NullPointerException.class, () -> new StreamEvent(1, null, "test")),
                () -> assertThrows(NullPointerException.class, () -> new StreamEvent(1, "test", null))
        );
    }
}
