package school.faang.distributedarmy.main;

import school.faang.distributedarmy.maincode.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordman(30));
        army.addUnit(new Mage(20));
        army.addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии " + totalPower);
    }
}
