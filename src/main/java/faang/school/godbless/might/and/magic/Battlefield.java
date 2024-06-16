package faang.school.godbless.might.and.magic;

public class Battlefield {

    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int hero1Damage = calculateTotalDamage(hero1);
        int hero2Damage = calculateTotalDamage(hero2);

        return hero1Damage > hero2Damage ? hero1 : hero2;
    }

    private int calculateTotalDamage(Hero hero) {
        int totalDamage = 0;
        for (Creature creature : hero.getArmy()) {
            totalDamage += creature.getAttack();
        }
        return totalDamage;
    }

}
