package school.faang.sprint3.BJS2_61144;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.sprint3.BJS2_61144.fighters.Archer;
import school.faang.sprint3.BJS2_61144.fighters.Mage;
import school.faang.sprint3.BJS2_61144.fighters.Swordsman;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    private Army army;

    @BeforeEach
    public void setUp() {
        army = new Army();
    }

    @Test
    public void calculateTotalPower() {
        fillArmy();
        long excepted = 675L;
        assertEquals(excepted, army.calculateTotalPower());
    }

    private void fillArmy() {
        Squad<Archer> archers1 = new Squad<>(List.of(new Archer(25), new Archer(30)));
        Squad<Archer> archers2 = new Squad<>(List.of(new Archer(25), new Archer(30)));
        Squad<Archer> archers3 = new Squad<>(List.of(new Archer(25), new Archer(30)));
        Squad<Swordsman> swordsmen1 = new Squad<>(List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Swordsman> swordsmen2 = new Squad<>(List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Swordsman> swordsmen3 = new Squad<>(List.of(new Swordsman(40), new Swordsman(35)));
        Squad<Mage> mages1 = new Squad<>(List.of(new Mage(50), new Mage(45)));
        Squad<Mage> mages2 = new Squad<>(List.of(new Mage(50), new Mage(45)));
        Squad<Mage> mages3 = new Squad<>(List.of(new Mage(50), new Mage(45)));

        army.addSquad(archers1);
        army.addSquad(archers2);
        army.addSquad(archers3);
        army.addSquad(swordsmen1);
        army.addSquad(swordsmen2);
        army.addSquad(swordsmen3);
        army.addSquad(mages1);
        army.addSquad(mages2);
        army.addSquad(mages3);
    }

    @Test
    public void calculateTotalPower__emptyArmy() {
        assertEquals(0, army.calculateTotalPower());
    }

    @Test
    public void calculateTotalPower__oneSquad() {
        army.addSquad(new Squad<>(List.of(new Archer(23))));
        int excepted = 23;
        assertEquals(excepted, army.calculateTotalPower());
    }

    @Test
    public void calculateTotalPower_oneSquad_hasNullFighter() {
        List<Archer> archers = new ArrayList<>();
        archers.add(new Archer(23));
        archers.add(null);

        army.addSquad(new Squad<>(archers));
        int excepted = 23;
        assertEquals(excepted, army.calculateTotalPower());
    }

    @Test
    public void calculateTotalPower_oneSquad_emptyFighters() {
        army.addSquad(new Squad<>(new ArrayList<>()));
        int excepted = 0;
        assertEquals(excepted, army.calculateTotalPower());
    }

}