package school.faang.sprint_3;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army(List.of(
                new Archer(25),
                new Swordsman(40),
                new Mage(50),
                new Mage(20),
                new Mage(20),
                new Archer(25),
                new Swordsman(40),
                new Mage(50),
                new Mage(20),
                new Mage(20),
                new Archer(25),
                new Swordsman(40),
                new Mage(50),
                new Mage(20),
                new Mage(20)
        ));
        army.calculateTotalPower();
    }
}
