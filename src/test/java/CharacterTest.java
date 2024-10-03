import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    @Test
    @DisplayName("check method attack")
    void positiveTestAttack(){
        Character Zhubanysh = new Warrior("Zhubanysh");
        Character Bekassyl = new Archer("Bekassyl");

        Zhubanysh.attack(Bekassyl);
        Zhubanysh.attack(Bekassyl);
        Bekassyl.attack(Zhubanysh);

        assertEquals(97, Zhubanysh.getHealth());
        assertEquals(80, Bekassyl.getHealth());
    }
}
