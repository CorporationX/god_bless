package hogvarts;

import faang.school.godbless.hogvarts.SpellCaster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellCasterTest {
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  private SpellCaster spellCaster;

  @BeforeEach
  public void setUp() {
    spellCaster = new SpellCaster();
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void castTest() {
    String alohomora = "Alohomora";
    String lumos = "Lumos";

    spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);

    assertEquals("The door is unlocked by Alohomora", outputStreamCaptor.toString()
        .trim());

    outputStreamCaptor.reset();

    spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
    assertEquals("A beam of light is created by Lumos", outputStreamCaptor.toString()
        .trim());

    outputStreamCaptor.reset();
  }
}
