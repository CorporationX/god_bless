package school.faang.task312;

import school.faang.task312.character.Archer;
import school.faang.task312.character.Army;
import school.faang.task312.character.Mage;
import school.faang.task312.character.Swordsman;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }

}
