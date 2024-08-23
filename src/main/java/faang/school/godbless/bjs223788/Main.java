package faang.school.godbless.bjs223788;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Army army = new Army(List.of(
                new Archer(25),
                new Swordsman(45),
                new Mage(50),
                new Mage(20),
                new Archer(55),
                new Swordsman(30),
                new Mage(15),
                new Mage(30),
                new Archer(50),
                new Swordsman(45),
                new Mage(35),
                new Mage(15)
        ));
        int totalPower = army.calculateTotalPower();

        System.out.println(totalPower);
    }
}