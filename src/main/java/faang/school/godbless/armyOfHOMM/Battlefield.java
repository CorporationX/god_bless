package faang.school.godbless.armyOfHOMM;

import java.util.List;

public class Battlefield {
    public static void main(String[] args) {
        Army army = new Army(List.of(
                new Archer(25),
                new Mage(10),
                new Swordsman(50),
                new Mage(20),
                new Swordsman(50)
        ));

        System.out.println(army.calculatePower());
    }
}
