package dima.evseenko.heroes;

import dima.evseenko.heroes.entity.Angel;
import dima.evseenko.heroes.entity.Creature;
import dima.evseenko.heroes.entity.Griffin;
import dima.evseenko.heroes.entity.Pikeman;
import dima.evseenko.heroes.entity.Swordman;

public class Main {
    public static void main(String[] args) {

        Hero dima = new Hero("Dima", Fraction.PEOPLE, 1, 1);
        dima.addCreature(getPikeman(3), 50);
        dima.addCreature(getSwordman(2), 10);

        Hero vasya = new Hero("Vasya", Fraction.ELVES, 1, 1);
        vasya.addCreature(getGriffin(2), 15);
        vasya.addCreature(getPikeman(2), 10);
        vasya.addCreature(getAngel(3), 5);

        System.out.println(dima.getArmy().size());
        System.out.println(vasya.getArmy().size());

        System.out.println(dima);
        System.out.println(vasya);

        vasya.deleteCreature(getPikeman(2), 2);

        System.out.println(vasya);

        Battlefield battlefield = new Battlefield(dima, vasya);

        System.out.println(battlefield.battle());

        System.out.println(dima.getArmy().size());
        System.out.println(vasya.getArmy().size());
    }

    private static Creature getPikeman(int level) {
        Creature pikeman = new Pikeman("ULTRA PIKEMAN");
        pikeman.setLevel(level);
        return pikeman;
    }

    private static Creature getGriffin(int level) {
        Creature griffin = new Griffin("ULTRA GRIFFIN");
        griffin.setLevel(level);
        return griffin;
    }

    private static Creature getSwordman(int level) {
        Creature swordman = new Swordman("ULTRA SWORDMAN");
        swordman.setLevel(level);
        return swordman;
    }

    private static Creature getAngel(int level) {
        Creature angel = new Angel("ULTRA ANGEL");
        angel.setLevel(level);
        return angel;
    }
}
