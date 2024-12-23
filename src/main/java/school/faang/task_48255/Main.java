package school.faang.task_48255;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Unit> units = List.of(
                new Archer(25),
                new Swordsman(40),
                new Mage(50),
                new Mage(20),
                new Archer(30),
                new Swordsman(35),
                new Mage(45),
                new Archer(28),
                new Swordsman(38),
                new Mage(60),
                new Archer(22),
                new Swordsman(42),
                new Mage(55),
                new Archer(27),
                new Mage(48)
        ); //expected 565

        Army army = new Army(units);

        int total = army.calculateTotalPower();

        System.out.println("Total power-- " + total);

    }
}
