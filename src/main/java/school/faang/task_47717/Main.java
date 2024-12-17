package school.faang.task_47717;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        List<Unit> list = Arrays.asList(new Archer(25), new Mage(50),
                new Swordsman(15), new Archer(30), new Mage(10), new Swordsman(55),
                new Mage(510), new Swordsman(125));

        for (Unit unit : list) {
            army.addUnit(unit);
        }

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии " + totalPower);
    }
}
