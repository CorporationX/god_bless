package school.faang.bjs245597;

import org.junit.jupiter.api.Test;

public class SpellCasterTest {

    @Test
    public void cast() {
        new SpellCaster().cast("lumus", String::toUpperCase);
    }
}