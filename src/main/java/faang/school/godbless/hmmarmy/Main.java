package faang.school.godbless.hmmarmy;

import faang.school.godbless.hmmarmy.characters.Archer;
import faang.school.godbless.hmmarmy.characters.Mage;
import faang.school.godbless.hmmarmy.characters.Swordsman;

public class Main {

    public static void main(String[] args) {
        Army army = new Army();

        Archer archer = new Archer(25);
        System.out.println(archer.getPower());
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int power = army.calculateTotalPower();

        System.out.println("Total army power: " + power);

    }
}
