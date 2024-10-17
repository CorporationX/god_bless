package dima.evseenko.army;

import dima.evseenko.army.unit.Archer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArmyTest {

    @Test
    void calculateTotalPower() {
        Army army = new Army();
        army.addUnit(new Archer(10));
        army.addUnit(new Archer(10));
        army.addUnit(new Archer(10));
        army.addUnit(new Archer(10));
        army.addUnit(new Archer(10));
        army.addUnit(new Archer(10));
        army.addUnit(new Archer(10));
        army.addUnit(new Archer(10));

        assertEquals(80, army.calculateTotalPower());
    }
}