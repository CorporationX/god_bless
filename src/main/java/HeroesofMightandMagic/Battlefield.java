package HeroesofMightandMagic;

import java.util.List;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        List<Creature> army1 = hero1.getArmy();
        List<Creature> army2 = hero2.getArmy();

        int armorHealthArmy1 = 0;
        int damageArmy1 = 0;
        for (Creature creature : army1) {
            armorHealthArmy1 += creature.defence() * creature.amount();
            damageArmy1 += creature.getDamage();
        }

        int armorHealthArmy2 = 0;
        int damageArmy2 = 0;
        for (Creature creature : army2) {
            armorHealthArmy2 += creature.defence() * creature.amount();
            damageArmy2 += creature.getDamage();
        }

        while (armorHealthArmy1 > 0 && armorHealthArmy2 > 0) {
            armorHealthArmy1 -= damageArmy2;
            armorHealthArmy2 -= damageArmy1;
        }
        return armorHealthArmy1 > armorHealthArmy2 ? hero1 : hero2;
    }

}
