package school.faang.armyOfHeroes;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Squad archers = new Squad("Archers");
        Squad swordsmen = new Squad("Swordsmen");
        Squad mages = new Squad("Mages");
        Army army = new Army();
        Random random = new Random();

        for (int i = 1; i <= 100; i++) {
            archers.addHero(new Archer(25 + random.nextInt(31)));
            swordsmen.addHero(new Swordsman(25 + random.nextInt(31)));
            mages.addHero(new Mage(25 + random.nextInt(31)));
        }

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        try {
            int totalPowerArmy = army.calculateTotalPower();
            System.out.println("Total power army: " + totalPowerArmy);
        } catch (Exception  e) {
            e.printStackTrace();
        }

    }
}
