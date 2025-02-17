package school.faang.BJS2_61080;

import school.faang.BJS2_61080.army.Army;
import school.faang.BJS2_61080.army.Squad;
import school.faang.BJS2_61080.units.Archer;
import school.faang.BJS2_61080.units.Mage;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad squadArcher = new Squad(List.of(
                new Archer(10),
                new Archer(10),
                new Archer(10)
        ));

        Squad squadMage = new Squad(List.of(
                new Mage(20),
                new Mage(20),
                new Mage(20)
        ));

        Squad squadSwordMan = new Squad(List.of(
                new Mage(30),
                new Mage(30),
                new Mage(30)
        ));

        Army army = new Army(List.of(squadArcher, squadMage, squadSwordMan));
        army.calculateTotalPower();
    }
}
