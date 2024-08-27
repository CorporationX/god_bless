package faang.school.godbless.sword_and_magic;

import faang.school.godbless.sword_and_magic.units.Archer;
import faang.school.godbless.sword_and_magic.units.Mage;
import faang.school.godbless.sword_and_magic.units.Swordsman;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Army army = new Army(List.of(
                new Swordsman(50),
                new Swordsman(60),
                new Swordsman(70),
                new Archer(30),
                new Archer(40),
                new Archer(50),
                new Mage(70),
                new Mage(80),
                new Mage(90)
        ));
        System.out.printf("Army total power: %d", army.calculateTotalPower());
    }
}
