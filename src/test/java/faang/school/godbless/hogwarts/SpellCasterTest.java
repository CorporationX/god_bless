package faang.school.godbless.hogwarts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpellCasterTest {

    @Test
    @DisplayName("Empty/null arguments")
    public void testInvalidArgs() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SpellCaster caster = new SpellCaster();
            caster.cast("", spell -> "Empty spell name passed in");
            caster.cast(null, spell -> "Null spell name passed in");
        });
    }

    @Test
    @DisplayName("Valid arguments")
    public void testValidArgs() {
        SpellCaster caster = new SpellCaster();

        Assertions.assertDoesNotThrow(() -> {
            caster.cast("Alohomora", sp -> "Unlocks doors and windows");
            caster.cast("Expelliarmus", sp -> "Disarms enemies");
            caster.cast("Accio", sp -> "Attracts an item to caster's location");
            caster.cast("Wingardium leviosa", sp -> "Makes a target object levitate");
            caster.cast("Avada Kedavra", sp -> "Kills enemies");
        });
    }
}
