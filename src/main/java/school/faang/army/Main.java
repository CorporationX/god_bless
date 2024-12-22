package school.faang.army;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        List<Unit> units = army.getUnits();
        Thread[] threads = new Thread[units.size()];

        for (int i = 0; i < units.size(); i++) {
            threads[i] = new Thread(units.get(i));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalPower = army.calculateTotalPower();
        System.out.println("The total power of army: " + totalPower);
    }
}
