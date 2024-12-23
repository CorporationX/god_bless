package school.faang.sprint_3.task_48027;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Unit> unitList= List.of(
                new Archer(25), new Swordsman(40), new Mage(50),
                new Mage(20), new Archer(25), new Swordsman(40),
                new Mage(50), new Archer(25), new Swordsman(40)
        );

        Army army = new Army(unitList);

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
