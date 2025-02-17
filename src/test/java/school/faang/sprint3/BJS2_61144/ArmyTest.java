package school.faang.sprint3.BJS2_61144;

import org.junit.jupiter.api.Test;
import school.faang.sprint3.BJS2_61144.fighters.Archer;
import school.faang.sprint3.BJS2_61144.fighters.Mage;
import school.faang.sprint3.BJS2_61144.fighters.Swordsman;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    private final Army army = new Army();

    @Test
    public void calculateTotalPower() {
        fillArmy();
        long excepted = 225L;
        assertEquals(excepted, army.calculateTotalPower());
    }

    private void fillArmy() {
        Squad<Archer> archers = new Squad<>(List.of(new Archer(25), new Archer(30)));
        Squad<Swordsman> swordsmen = new Squad<>(List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Mage> mages = new Squad<>(List.of(new Mage(50), new Mage(45)));

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);
    }
}