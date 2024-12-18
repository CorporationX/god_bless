package school.faang.sprint_3.task_47691;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Army army = new Army(new ArrayList<>());
        army.addWarrior(new Archer(25));
        army.addWarrior(new Swordsman(40));
        army.addWarrior(new Mage(50));
        army.addWarrior(new Mage(20));
        army.addWarrior(new Mage(20));
        army.addWarrior(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
