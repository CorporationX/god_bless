package faang.school.godbless.homm;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Army army = new Army(List.of(
            new Archer(25),
            new Swordsman(40),
            new Mage(50),
            new Mage(20)
        ));

        System.out.println(army.calculateTotalPower());
    }
}
