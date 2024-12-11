package school.faang.bjs245597;

import org.junit.jupiter.api.Test;

class SpellCasterTest {

    @Test
    void cast() {
        new SpellCaster().cast("lumus", String::toUpperCase);
    }
}