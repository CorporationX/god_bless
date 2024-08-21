package faang.school.godbless.task.multithreading.might.and.magic;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        IntStream.rangeClosed(1, 10)
                .forEach(i -> army.addUnits(new Archer("Archer " + i, 15)));
        IntStream.rangeClosed(1, 7)
                .forEach(i -> army.addUnits(new Mage("Mage " + i, 25)));
        IntStream.rangeClosed(1, 12)
                .forEach(i -> army.addUnits(new Swordsman("Swordsman " + i, 20)));
        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
