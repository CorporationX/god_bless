package faang.school.godbless.Army;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        List<Unit> units = List.of(new Archer(25), new Swordsman(40), new Mage(50), new Mage(20),
                new Archer(25), new Swordsman(40), new Mage(50), new Mage(20),
                new Archer(25), new Swordsman(40), new Mage(50), new Mage(20));


        Army army = new Army(units);


        int totalPower = army.calculateTotalPower();
        System.out.println("Total power: " + totalPower);


    }
}
