package faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic;

import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.Archer;
import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.Mage;
import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.Swordsman;
import faang.school.godbless.spring_4.distributed_army_of_heroes_of_might_and_magic.army.armys.Army;

public class Main {
    public static void main(String[] args) throws Exception {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(45));
        army.addUnit(new Swordsman(45));
        army.addUnit(new Mage(30));
        army.addUnit(new Mage(30));


        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
