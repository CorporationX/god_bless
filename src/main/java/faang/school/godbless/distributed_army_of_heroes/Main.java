package faang.school.godbless.distributed_army_of_heroes;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Creature> creatures = List.of(new Archer(25), new Swordsman(40), new Mage(50),
                new Mage(20), new Archer(25), new Swordsman(40), new Mage(50), new Archer(20));

        Army army = new Army(creatures);

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }

}
