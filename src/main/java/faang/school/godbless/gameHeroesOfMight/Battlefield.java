package faang.school.godbless.gameHeroesOfMight;

public class Battlefield {
    public enum BattleResult {
        HERO1_WINS, HERO2_WINS, TIE
    }

    public BattleResult battle(Hero h1, Hero h2) {
        int h1TotalDamage = h1.totalArmyDamage();
        int h2TotalDamage = h2.totalArmyDamage();

        if (h1TotalDamage > h2TotalDamage) {
            System.out.println(h1.getName() + " wins!");
            return BattleResult.HERO1_WINS;
        } else if (h1TotalDamage < h2TotalDamage) {
            System.out.println(h2.getName() + " wins!");
            return BattleResult.HERO2_WINS;
        } else {
            System.out.println("It's a tie!");
            return BattleResult.TIE;
        }
    }
}
