import heroes.Archer;
import heroes.Army;
import heroes.Mage;
import heroes.Squad;
import heroes.SquadType;
import heroes.Swordsman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ArmyTest {

    private Squad<Archer> archers;
    private Squad<Swordsman> swordsmen;
    private Squad<Mage> mages;
    private Army army;

    @BeforeEach
    public void setUp() {
        archers = new Squad<>(SquadType.ARCHERS_SQUAD.getSquadType(),
                List.of(new Archer(25), new Archer(25), new Archer(25)));
        swordsmen = new Squad<>(SquadType.SWORDSMEN_SQUAD.getSquadType(),
                List.of(new Swordsman(40), new Swordsman(40)));
        mages = new Squad<>(SquadType.MAGES_SQUAD.getSquadType(),
                List.of(new Mage(50), new Mage(50), new Mage(50), new Mage(50)));
        army = new Army(List.of(archers, swordsmen, mages));
    }

    @Test
    public void testSquadPowerCalculation() {
        int archerPower = archers.calculateSquadPower();
        int swordsmanPower = swordsmen.calculateSquadPower();
        int magePower = mages.calculateSquadPower();
        assertEquals(75, archerPower, "Power of Archers squad should be 75");
        assertEquals(80, swordsmanPower, "Power of Swordsmen squad should be 80");
        assertEquals(200, magePower, "Power of Mages squad should be 200");
    }

    @Test
    public void testArmyTotalPower() throws InterruptedException {
        int totalPower = army.calculateTotalPower();
        assertEquals(355, totalPower, "Total army power should be 355");
    }

    @Test
    public void testArmyPowerWithNoMages() throws InterruptedException {
        Army armyWithoutMages = new Army(List.of(archers, swordsmen));
        int totalPower = armyWithoutMages.calculateTotalPower();
        assertEquals(155, totalPower, "Total army power without Mages should be 155");
    }

    @Test
    public void testEmptyArmy() throws InterruptedException {
        Army emptyArmy = new Army(List.of());
        int totalPower = emptyArmy.calculateTotalPower();
        assertEquals(0, totalPower, "Total power of an empty army should be 0");
    }
}
