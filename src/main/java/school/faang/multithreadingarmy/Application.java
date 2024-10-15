package school.faang.multithreadingarmy;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer());
        army.addUnit(new Swordsman());
        army.addUnit(new Mage());
        army.addUnit(new Mage(20));
        army.addUnit(new Archer());
        army.addUnit(new Swordsman());
        army.addUnit(new Mage());

        try {
            int totalPower = army.calculateTotalPower();
            System.out.println("All power: " + totalPower);
        } catch (InterruptedException e) {
            System.out.println("Crash: " + Arrays.toString(e.getStackTrace()));
            throw new RuntimeException(e);
        }

    }
}
