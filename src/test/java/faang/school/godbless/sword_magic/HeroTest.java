package faang.school.godbless.sword_magic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeroTest {
    Hero hero;

    @BeforeEach
    void setUp(){
        hero = new Hero("Hero", "FractionOfHero", 2, 4);
        Angel angels = new Angel(1, 10);         // damage = 2;   armor = 6 -> {20, 60}
        Pikeman pikemen = new Pikeman(2, 20);    // damage = 12;  armor = 6 -> {240, 120}
        Griffin griffins = new Griffin(3, 30);   // damage = 27;  armor = 9 -> {810, 270}
        Swordman swordmen = new Swordman(4, 40); // damage = 64; armor = 8 -> {2560, 320}
                                                               // 3630          770
                                                               // 11536         800   boosted by exp and level
        hero.addCreature(angels);
        hero.addCreature(pikemen);
        hero.addCreature(griffins);
        hero.addCreature(swordmen);
    }

    @Test
    void testHero_addedArmy(){
        Map<Creature, Integer> result = Map.of(
                new Angel(1, 10), 10,
                new Pikeman(2, 20), 20,
                new Griffin(3, 30), 30,
                new Swordman(4, 40), 40);
        assertEquals(hero.getArmy(), result);
    }

    @Test
    void testHero_addingExistingCreature(){
        Angel angelToAdd = new Angel(1, 10);
        hero.addCreature(angelToAdd);

        Map<Creature, Integer> result = Map.of(
                new Angel(1, 20), 20,
                new Pikeman(2, 20), 20,
                new Griffin(3, 30), 30,
                new Swordman(4, 40), 40);
        assertEquals(hero.getArmy(), result);
    }

    @Test
    void testHero_addingNotExistingCreature(){
        Angel angelToAdd = new Angel(2, 10);
        hero.addCreature(angelToAdd);

        Map<Creature, Integer> result = Map.of(
                new Angel(1, 10), 10,
                new Angel(2, 10), 10,
                new Pikeman(2, 20), 20,
                new Griffin(3, 30), 30,
                new Swordman(4, 40), 40);
        assertEquals(hero.getArmy(), result);
    }

    @Test
    void testHero_removingOneExistingCreature(){
        Angel angelToRemove = new Angel(1, 10);
        hero.removeCreature(angelToRemove);

        Map<Creature, Integer> result = Map.of(
                new Pikeman(2, 20), 20,
                new Griffin(3, 30), 30,
                new Swordman(4, 40), 40);
        assertEquals(hero.getArmy(), result);
    }

    @Test
    void testHero_removingPartOfExistingCreature(){
        Angel angelToRemove = new Angel(1, 5);
        hero.removeCreature(angelToRemove);

        Map<Creature, Integer> result = Map.of(
                new Angel(1, 5), 5,
                new Pikeman(2, 20), 20,
                new Griffin(3, 30), 30,
                new Swordman(4, 40), 40);
        assertEquals(hero.getArmy(), result);
    }

    @Test
    void testHero_removingMoreThanExistingCreature(){
        Angel angelToRemove = new Angel(1, 20);
        hero.removeCreature(angelToRemove);

        Map<Creature, Integer> result = Map.of(
                new Pikeman(2, 20), 20,
                new Griffin(3, 30), 30,
                new Swordman(4, 40), 40);
        assertEquals(hero.getArmy(), result);
    }

    @Test
    void testHero_getDamage(){
        int damageOfArmy = hero.getDamageOfArmy();

        assertEquals(3702, damageOfArmy);
    }

    @Test
    void testHero_getArmor(){
        int armorOfArmy = hero.getArmorOfArmy();

        assertEquals(800, armorOfArmy);
    }

    @Test
    void testHero_negativeExperience(){
        assertThrows(IllegalArgumentException.class, () -> new Hero("Hero", "Fraction", -1, 0));
    }

    @Test
    void testHero_negativeLevel(){
        assertThrows(IllegalArgumentException.class, () -> new Hero("Hero", "Fraction", 0, -1));
    }
}