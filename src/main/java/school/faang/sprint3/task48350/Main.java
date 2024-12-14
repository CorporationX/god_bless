package school.faang.sprint3.task48350;

import school.faang.sprint3.task48350.model.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Army army = new Army();

        army.addWarrior(new Archer());
        army.addWarrior(new Knight());
        army.addWarrior(new Swordsman());
        army.addWarrior(new Mage());
        army.addWarrior(new Swordsman());

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);

    }
}
