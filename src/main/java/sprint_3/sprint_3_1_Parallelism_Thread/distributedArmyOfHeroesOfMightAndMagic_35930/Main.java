package sprint_3.sprint_3_1_Parallelism_Thread.distributedArmyOfHeroesOfMightAndMagic_35930;

import sprint_3.sprint_3_1_Parallelism_Thread.distributedArmyOfHeroesOfMightAndMagic_35930.entity.Archer;
import sprint_3.sprint_3_1_Parallelism_Thread.distributedArmyOfHeroesOfMightAndMagic_35930.entity.Mage;
import sprint_3.sprint_3_1_Parallelism_Thread.distributedArmyOfHeroesOfMightAndMagic_35930.entity.Swordsman;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
