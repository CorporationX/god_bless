package faang.school.godbless.mightandmagic;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Unit> units = List.of(
                new Archer(40),new Swordsman(25),new Mage(50),
                new Archer(40),new Swordsman(25),new Mage(50),
                new Archer(40),new Swordsman(25),new Mage(50),
                new Archer(40),new Swordsman(25),new Mage(50),
                new Archer(40),new Swordsman(25),new Mage(50),
                new Archer(40),new Swordsman(25),new Mage(50)

        );
        Army army = new Army(units);
        long startTime = System.currentTimeMillis();
        int totalPower = army.calculateTotalPower();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + executionTime);
    }
}
