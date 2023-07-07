package faang.school.godbless.homm_army;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ArmyTests {

    Army army = new Army();

    List<Character> archers;
    List<Character> swordsmen;
    List<Character> mages;

    @BeforeEach
    public void setUp() {
        archers = army.generateCharacterList(Archer.class, 30, 12_312);
        swordsmen = army.generateCharacterList(Swordsman.class, 65, 52_349);
        mages = army.generateCharacterList(Mage.class, 100, 5_429);

        army.addUnits(archers);
        army.addUnits(swordsmen);
        army.addUnits(mages);
    }

    @Test
    @DisplayName("Should calculate TOTAL POWER!!!")
    public void shouldCalculateTotalPower() {
        int totalArchersPower = 30 * 12_312;
        int totalSwordsmenPower = 65 * 52_349;
        int totalMagesPower = 100 * 5_429;

        int totalExpectedPower = totalArchersPower + totalSwordsmenPower + totalMagesPower;

        Assertions.assertEquals(totalExpectedPower, army.calculateTotalPower()); //Should be like my monthly salary soon
    }
}
