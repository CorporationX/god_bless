package faang.school.godbless.dolbahlop;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int hero1Strength = calculateArmyStrength(hero1);
        int hero2Strength = calculateArmyStrength(hero2);

        return defineWinner(hero1Strength, hero2Strength);
    }

    private int calculateArmyStrength(Hero hero){
        return hero.calculateTotalDamage();
    }

    private Hero defineWinner(int hero1Strength, int hero2Strength) {
        if (hero1Strength >= hero2Strength) {
            return hero1;
        }
        return hero2;
    }
}
