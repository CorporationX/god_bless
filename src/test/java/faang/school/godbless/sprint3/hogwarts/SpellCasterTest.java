package faang.school.godbless.sprint3.hogwarts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpellCasterTest {
    private PrintStream console;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        console = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(console);
    }

    @ParameterizedTest
    @MethodSource("getParams")
    void cast_outputShouldMatch(String spellName, String spell, String expected) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(spellName, (n) -> spell + n);
        assertEquals(expected, output.toString().trim());
    }

    static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of("Alohomora",
                        "The door is unlocked by ",
                        "The door is unlocked by Alohomora"),
                Arguments.of("Lumos",
                        "A beam of light is created by ",
                        "A beam of light is created by Lumos"),
                Arguments.of("Expelliarmus",
                        "A beam of light is created by ",
                        "A beam of light is created by Expelliarmus")
        );
    }
}