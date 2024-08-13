import faang.school.godbless.hogwarts.SpellCaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HogwartsTest {

    @Test
    public void castTest() {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        Assertions.assertAll("All spells check",
                () -> Assertions.assertEquals("open the door " + alohomora,
                        spellCaster.cast(alohomora, name -> "open the door " + name)),

                () -> Assertions.assertEquals("A beam of light is created by " + lumos,
                        spellCaster.cast(lumos, name -> "A beam of light is created by " + name)),

                () -> Assertions.assertEquals("The opponent is disarmed by " + expelliarmus,
                        spellCaster.cast(expelliarmus, name -> "The opponent is disarmed by " + name))
        );
    }
}
