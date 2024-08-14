package faang.school.godbless.BJS2_20850;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SpellActionTest {

    @Test
    void testGetTheResultOfTheSpell() {
        SpellAction alohomoraSpellAction = (nameOfTheSpell) -> "The door is unlocked by " + nameOfTheSpell;

        assertEquals("The door is unlocked by Alohomora", alohomoraSpellAction.getTheResultOfTheSpell("Alohomora"));
        assertNotEquals("The door is unlocked by Lumos", alohomoraSpellAction.getTheResultOfTheSpell("Alohomora"));
    }
}