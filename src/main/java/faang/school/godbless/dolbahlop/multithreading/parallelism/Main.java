package faang.school.godbless.dolbahlop.multithreading.parallelism;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Unit> units = new ArrayList<>();
        units.add(new Archer(12));
        units.add(new Archer(2));
        units.add(new Mage(20));
        units.add(new Mage(25));
        units.add(new Swordsman(14));
        units.add(new Swordsman(30));
        Army army = new Army(units);
        System.out.println("Total army power is " + army.calculateTotalPower());
    }
}
