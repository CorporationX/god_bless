package tests_44605;

import org.junit.jupiter.api.Test;
import school.faang.task_44605.SpellEvent;
import school.faang.task_44605.Type;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpellEventTest {

    @Test
    void testSpellEvent_TypeIsNull() {
        int id = 13;
        Type type = null;

        assertThrows(NullPointerException.class, () -> new SpellEvent(id, type));
    }
}
