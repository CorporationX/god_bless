package faang.school.godbless.mt.army;

import faang.school.godbless.mt.army.units.Archer;
import faang.school.godbless.mt.army.units.Mage;
import faang.school.godbless.mt.army.units.Swordsman;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army(List.of(
                new Mage(10),
                new Mage(30),
                new Archer(25),
                new Swordsman(50),
                new Mage(15),
                new Swordsman(40),
                new Archer(30),
                new Archer(25),
                new Mage(50),
                new Mage(100)
        )); // total = 375

        int power = army.calculateTotalPower();
        System.out.println(power);
    }
}
