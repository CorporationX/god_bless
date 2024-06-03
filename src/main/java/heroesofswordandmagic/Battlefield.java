package heroesofswordandmagic;

import java.util.List;

public class Battlefield {

    public static void battle(Hero firstHero, Hero secondHero, List<Creature> firstHeroArmy, List<Creature> secondHeroArmy) {
        int powerOfFirstHero = 0;
        int powerOfSecondHero = 0;

        for (Creature creature : firstHeroArmy) {
            powerOfFirstHero+= creature.getDamage() + creature.getLevel() + creature.getDefense() + creature.getSpeed();
        }

        for (Creature creature : secondHeroArmy) {
            powerOfSecondHero+= creature.getDamage() + creature.getLevel() + creature.getDefense() + creature.getSpeed();
        }

        if(powerOfFirstHero > powerOfSecondHero) {
            System.out.println(firstHero.getName() + " wins!!!");
        } else if (powerOfFirstHero < powerOfSecondHero) {
            System.out.println(secondHero.getName() + " wins!!!");
        } else {
            System.out.println("Even!!!");
        }
    }

    public static void main(String[] args) {
        Hero firstHero = new Hero("Axe", "Dark", 15, 10);
        Hero secondHero = new Hero("Pudge", "Light", 15, 10);

        Creature creature = new Angel("Angel",4, 40, 40, 40, 40);
        Creature creature1 = new Pikeman("Pikeman", 1, 10, 10, 10, 10);
        Creature creature2= new Griffin("Griffin",2, 20, 20, 20, 20);
        Creature creature3 = new Swordman("Pikeman", 3, 30, 30, 30, 30);
        firstHero.addCreature(creature, 10);
        firstHero.addCreature(creature1, 100);
        secondHero.addCreature(creature2, 1);
        secondHero.addCreature(creature3, 1);

        battle(firstHero, secondHero, firstHero.getArmy(), secondHero.getArmy());
    }
}
