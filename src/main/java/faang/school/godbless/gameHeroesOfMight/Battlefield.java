package faang.school.godbless.gameHeroesOfMight;

public class Battlefield {
    public Hero battle(Hero h1, Hero h2) {
        int h1TotalDamage = h1.totalArmyDamage();
        int h2TotalDamage = h2.totalArmyDamage();

        if (h1TotalDamage > h2TotalDamage) {
            System.out.println(h1.getName() + " wins!");
            return h1;
        } else if (h1TotalDamage < h2TotalDamage) {
            System.out.println(h2.getName() + " wins!");
            return h2;
        } else {
            System.out.println("It's a tie!");
            return null; // Tie, no winner
        }
    }}
