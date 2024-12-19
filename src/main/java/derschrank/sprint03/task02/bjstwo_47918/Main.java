package derschrank.sprint03.task02.bjstwo_47918;

import derschrank.sprint03.task02.bjstwo_47918.units.Archer;
import derschrank.sprint03.task02.bjstwo_47918.units.Mage;
import derschrank.sprint03.task02.bjstwo_47918.units.Swordsman;
import derschrank.sprint03.task02.bjstwo_47918.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        for (int i = 0; i < 6000; i++) {
            army.addUnit(new Archer());
        }

        for (int i = 0; i < 3000; i++) {
            army.addUnit(new Mage());
        }

        for (int i = 0; i < 2000; i++) {
            army.addUnit(new Swordsman());
        }

        army.calculateTotalPower();
    }

}
