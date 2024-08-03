package faang.school.godbless.BJS2_18872;

import java.util.HashMap;

public class Battlefield {

    Hero hero1;
    Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int damageHero1 = hero1.calculateTotalDamage();
        int damageHero2 = hero2.calculateTotalDamage();

        System.out.println(hero1.getName() + " damage " + damageHero1 + " to " + hero2.getName());
        System.out.println(hero2.getName() + " damage " + damageHero2 + " to " + hero1.getName());

        if (damageHero1 > damageHero2) {
            System.out.println(hero1.getName() + " won!");
            hero1.setExperience(hero1.getExperience() + 1000);
            return hero1;
        } else if (damageHero2 > damageHero1) {
            System.out.println(hero2.getName() + " won!");
            hero1.setExperience(hero2.getExperience() + 1000);
            return hero2;
        } else {
            System.out.println("Tie!");
            return null;
        }
    }
}
