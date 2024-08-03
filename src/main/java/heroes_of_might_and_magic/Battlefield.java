package heroes_of_might_and_magic;

import heroes_of_might_and_magic.creatures.Creature;

import java.util.Random;

public class Battlefield {
    private static final Random random = new Random();

    Hero hero1;
    Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        while (true) {
            if (hero1.getArmy().isEmpty()) {
                return hero2;
            } else if (hero2.getArmy().isEmpty()) {
                return hero1;
            } else {
                makeTurn();
            }
        }
    }

    private void makeTurn() {
        int rndIntToHero1 = random.nextInt(hero1.getArmy().size());
        int rndIntToHero2 = random.nextInt(hero2.getArmy().size());

        Creature hero1Creature = hero1.getArmy().get(rndIntToHero1);
        Creature hero2Creature = hero2.getArmy().get(rndIntToHero2);

        if (hero1Creature.getSpeed() >= hero2Creature.getSpeed()) {
            damageExchange(hero1Creature, hero2Creature, hero1, hero2);
        } else {
            damageExchange(hero2Creature, hero1Creature, hero2, hero1);
        }
    }

    /*Выглядит очень грязно, но очень хотелось сделать что-нибудь в таком духе.
    /* Этот метод описывает "обмен ударами" между двумя существами: сначала удар делает существо1, затем, если сущ-во 2 выживает, отвечает ему
     * в задании попросили добавить поле брони, решил его тут применить, броня просто показывает сопротивление урону в процентах
     */
    private void damageExchange(Creature creature1, Creature creature2, Hero hero1, Hero hero2) {
        int damageTo = creature1.getDamage() * (1 - creature2.getArmor() / 100);
        creature2.setHealth(creature2.getHealth() - damageTo);

        System.out.printf("%s нанес %s %d урона%n",
                creature1.getName(), creature2.getName(), damageTo);

        if (creature2.getHealth() <= 0) {
            hero2.removeCreature(creature2, 1);
            System.out.printf("Существо %s погибло. У героя %s осталось %d существ%n",
                    creature2.getName(), hero2.getName(), hero2.getArmy().size());
        } else {
            damageTo = creature2.getDamage() * (1 - creature1.getArmor() / 100);
            creature1.setHealth(creature1.getHealth() - damageTo);
            System.out.printf("%s нанес %s %d урона%n",
                    creature2.getName(), creature1.getName(), damageTo);
            if (creature1.getHealth() <= 0) {
                hero1.removeCreature(creature1, 1);
                System.out.printf("Существо %s погибло. У героя %s осталось %d существ%n",
                        creature1.getName(), hero1.getName(), hero1.getArmy().size());
            }
        }
    }

}
