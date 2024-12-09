package school.faang.bjs_45459;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SpellCasterTest {

    public static Stream<Arguments> spellParametersForTest() {
        return Stream.of(
                Arguments.of("Alohomora", "The door is unlocked by ", "The door is unlocked by Alohomora"),
                Arguments.of("Lumos", "A beam of light is created by ",
                        "A beam of light is created by Lumos"),
                Arguments.of("Expelliarmus", "The opponent is disarmed by ",
                        "The opponent is disarmed by Expelliarmus")
        );
    }

    @ParameterizedTest
    @MethodSource("spellParametersForTest")
    void cast(String spellName, String spellDescription, String exceptedMessage) {
        SpellCaster spellCaster = new SpellCaster();
        String actual = spellCaster.cast(spellName, (spell) -> spellDescription + spell);
        Assertions.assertEquals(exceptedMessage, actual);
    }
}