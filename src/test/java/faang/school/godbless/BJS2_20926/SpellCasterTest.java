package faang.school.godbless.BJS2_20926;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class SpellCasterTest {
    private final ByteArrayOutputStream OUTPUT_STREAM_CAPTOR = new ByteArrayOutputStream();
    private static final PrintStream ORIGINAL_OUT = System.out;
    private SpellCaster spellCaster;
    String alohomora = "Alohomora";
    String lumos = "Lumos";
    String expelliarmus = "Expelliarmus";

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(OUTPUT_STREAM_CAPTOR));
        spellCaster = new SpellCaster();
    }

    @Test
    void alohomoraSpell() {
        String expected = "The door is unlocked by " + alohomora;
        spellCaster.cast(alohomora, spell -> "The door is unlocked by " + spell);

        assertThat(normalize(OUTPUT_STREAM_CAPTOR.toString())).isEqualTo(expected);
        System.setOut(ORIGINAL_OUT);
        System.out.println(OUTPUT_STREAM_CAPTOR);
    }

    @Test
    void lumosSpell() {
        String expected = "A beam of light is created by " + lumos;
        spellCaster.cast(lumos, spell -> "A beam of light is created by " + lumos);

        assertThat(normalize(OUTPUT_STREAM_CAPTOR.toString())).isEqualTo(expected);
        System.setOut(ORIGINAL_OUT);
        System.out.println(OUTPUT_STREAM_CAPTOR);
    }

    @Test
    void expelliarmusSpell() {
        String expected = "The opponent is disarmed by " + expelliarmus;
        spellCaster.cast(expelliarmus, spell -> "The opponent is disarmed by " + expelliarmus);
        assertThat(normalize(OUTPUT_STREAM_CAPTOR.toString())).isEqualTo(expected);
        System.setOut(ORIGINAL_OUT);
        System.out.println(OUTPUT_STREAM_CAPTOR);
    }

    private String normalize(String input) {
        return input.strip().replaceAll("\\s+", " ");
    }
}