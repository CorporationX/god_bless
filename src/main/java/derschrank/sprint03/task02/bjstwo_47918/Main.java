package derschrank.sprint03.task02.bjstwo_47918;

import derschrank.sprint03.task02.bjstwo_47918.units.Archer;
import derschrank.sprint03.task02.bjstwo_47918.units.Mage;
import derschrank.sprint03.task02.bjstwo_47918.units.Swordsman;
import derschrank.sprint03.task02.bjstwo_47918.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int countOfArcher = 6000;
        final int countOfMage = 3000;
        final int countOfSwordsman = 2000;

        Army army = new Army();

        for (int i = 0; i < countOfArcher; i++) {
            army.addUnit(new Archer());
        }

        for (int i = 0; i < countOfMage; i++) {
            army.addUnit(new Mage());
        }

        for (int i = 0; i < countOfSwordsman; i++) {
            army.addUnit(new Swordsman());
        }

        army.calculateTotalPower();
    }

}
