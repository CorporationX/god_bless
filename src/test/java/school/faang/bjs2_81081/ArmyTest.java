package school.faang.bjs2_81081;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    private final Squad<Archer> archers = new Squad<>(List.of(new Archer(25), new Archer(30)));
    private final Squad<Swordsman> swordsmen = new Squad<>(List.of(new Swordsman(40), new Swordsman(35)));
    private final Squad<Mage> mages = new Squad<>(List.of(new Mage(50), new Mage(45)));
    private final Army army = new Army();

    @Test
    void shouldCalculateTotalPower() {
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        int expected = archers.calculateSquadPower() + swordsmen.calculateSquadPower() + mages.calculateSquadPower();

        int actual = army.calculateTotalPower();

        assertEquals(expected, actual);
    }

    @Test
    void shouldAddSquad() {
        army.addSquad(archers);

        boolean actual = army.getSquads().contains(archers);

        assertTrue(actual);
    }
}