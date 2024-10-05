package dima.evseenko.heroes;

import dima.evseenko.heroes.entity.Angel;
import dima.evseenko.heroes.entity.Creature;
import dima.evseenko.heroes.entity.Griffin;
import dima.evseenko.heroes.entity.Pikeman;
import dima.evseenko.heroes.entity.Swordman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattlefieldTest {

    @Test
    void battle() {
        Hero dima = new Hero("Dima", Hero.Fraction.PEOPLE, 1, 1);
        dima.addCreature(getPikeman(3), 50);
        dima.addCreature(getSwordman(2), 10);

        Hero vasya = new Hero("Vasya", Hero.Fraction.ELVES, 1, 1);
        vasya.addCreature(getGriffin(2), 15);
        vasya.addCreature(getPikeman(2), 10);
        vasya.addCreature(getAngel(3), 5);

        Battlefield battlefield = new Battlefield(dima, vasya);

        assertEquals(dima, battlefield.battle());
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