package faang.school.godbless.sword_magic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BattlefieldTest {

    @Test
    void testBattlefield_battleTwoEqualHeroes(){
        Hero hero = new Hero("Hero", "FractionOfHero", 1, 1);
        Angel angels = new Angel(1);
        Pikeman pikemen = new Pikeman(2);
        Griffin griffins = new Griffin(3);
        Swordman swordmen = new Swordman(4);

        hero.addCreature(angels, 10);
        hero.addCreature(pikemen, 20);
        hero.addCreature(griffins, 30);
        hero.addCreature(swordmen, 40);

        Battlefield battlefield = new Battlefield(hero, hero);
        Hero winningHero = battlefield.battle();

        assertNull(winningHero);
    }

    @Test
    void testBattlefield_battleHeroesFirstWins(){
        Hero hero1 = new Hero("Hero1", "FractionOfHero1", 1, 1);
        Angel angels1 = new Angel(1);
        Pikeman pikemen1 = new Pikeman(2);
        Griffin griffins1 = new Griffin(3);
        Swordman swordmen1 = new Swordman(4);
        hero1.addCreature(angels1, 11);
        hero1.addCreature(pikemen1, 20);
        hero1.addCreature(griffins1, 30);
        hero1.addCreature(swordmen1, 40);

        Hero hero2 = new Hero("Hero2", "FractionOfHero2", 1, 1);
        Angel angels2 = new Angel(1);
        Pikeman pikemen2 = new Pikeman(2);
        Griffin griffins2 = new Griffin(3);
        Swordman swordmen2 = new Swordman(4);
        hero2.addCreature(angels2, 10);
        hero2.addCreature(pikemen2, 20);
        hero2.addCreature(griffins2, 30);
        hero2.addCreature(swordmen2, 40);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winningHero = battlefield.battle();

        assertEquals(hero1, winningHero);
    }

    @Test
    void testBattlefield_battleHeroesSecondWins(){
        Hero hero1 = new Hero("Hero1", "FractionOfHero1", 1, 1);
        Angel angels1 = new Angel(1);
        Pikeman pikemen1 = new Pikeman(2);
        Griffin griffins1 = new Griffin(3);
        Swordman swordmen1 = new Swordman(4);
        hero1.addCreature(angels1, 10);
        hero1.addCreature(pikemen1, 20);
        hero1.addCreature(griffins1, 30);
        hero1.addCreature(swordmen1, 40);

        Hero hero2 = new Hero("Hero2", "FractionOfHero2", 1, 1);
        Angel angels2 = new Angel(1);
        Pikeman pikemen2 = new Pikeman(2);
        Griffin griffins2 = new Griffin(3);
        Swordman swordmen2 = new Swordman(4);
        hero2.addCreature(angels2, 11);
        hero2.addCreature(pikemen2, 20);
        hero2.addCreature(griffins2, 30);
        hero2.addCreature(swordmen2, 40);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winningHero = battlefield.battle();

        assertEquals(hero2, winningHero);
    }
}