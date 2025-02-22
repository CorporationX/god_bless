package school.faang.armyOfHeroes;

import java.util.Random;

public class Main {
    private static final int MIN_POWER = 25;
    private static final int MAX_DIFF_POWER = 31;

    public static void main(String[] args) {
        Squad archers = new Squad("Archers");
        Squad swordsmen = new Squad("Swordsmen");
        Squad mages = new Squad("Mages");
        Army army = new Army();
        Random random = new Random();

        for (int i = 1; i <= 100; i++) {
            archers.addHero(new Archer(MIN_POWER + random.nextInt(MAX_DIFF_POWER)));
            swordsmen.addHero(new Swordsman(MIN_POWER + random.nextInt(MAX_DIFF_POWER)));
            mages.addHero(new Mage(MIN_POWER + random.nextInt(MAX_DIFF_POWER)));
        }

        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        try {
            int totalPowerArmy = army.calculateTotalPower();
            System.out.println("Total power army: " + totalPowerArmy);
        } catch (InterruptedException  e) {
            e.printStackTrace();
        }

    }
}
