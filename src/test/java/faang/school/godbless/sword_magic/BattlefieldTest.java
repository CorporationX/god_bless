package faang.school.godbless.sword_magic;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BattlefieldTest {

    @Test
    void testBattlefield_battleTwoEqualHeroes(){
        Hero hero = new Hero("Hero", "FractionOfHero", 1, 1);
        Angel angels = new Angel(1, 10);
        Pikeman pikemen = new Pikeman(2, 20);
        Griffin griffins = new Griffin(3, 30);
        Swordman swordmen = new Swordman(4, 40);

        hero.addCreature(angels);
        hero.addCreature(pikemen);
        hero.addCreature(griffins);
        hero.addCreature(swordmen);

        Battlefield battlefield = new Battlefield(hero, hero);
        Hero winningHero = battlefield.battle();

        assertNull(winningHero);
    }

    @Test
    void testBattlefield_battleHeroesFirstWins(){
        Hero hero1 = new Hero("Hero1", "FractionOfHero1", 1, 1);
        Angel angels1 = new Angel(1, 11);
        Pikeman pikemen1 = new Pikeman(2, 20);
        Griffin griffins1 = new Griffin(3, 30);
        Swordman swordmen1 = new Swordman(4, 40);
        hero1.addCreature(angels1);
        hero1.addCreature(pikemen1);
        hero1.addCreature(griffins1);
        hero1.addCreature(swordmen1);

        Hero hero2 = new Hero("Hero2", "FractionOfHero2", 1, 1);
        Angel angels2 = new Angel(1, 10);
        Pikeman pikemen2 = new Pikeman(2, 20);
        Griffin griffins2 = new Griffin(3, 30);
        Swordman swordmen2 = new Swordman(4, 40);
        hero2.addCreature(angels2);
        hero2.addCreature(pikemen2);
        hero2.addCreature(griffins2);
        hero2.addCreature(swordmen2);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winningHero = battlefield.battle();

        assertEquals(hero1, winningHero);
    }

    @Test
    void testBattlefield_battleHeroesSecondWins(){
        Hero hero1 = new Hero("Hero1", "FractionOfHero1", 1, 1);
        Angel angels1 = new Angel(1, 10);
        Pikeman pikemen1 = new Pikeman(2, 20);
        Griffin griffins1 = new Griffin(3, 30);
        Swordman swordmen1 = new Swordman(4, 40);
        hero1.addCreature(angels1);
        hero1.addCreature(pikemen1);
        hero1.addCreature(griffins1);
        hero1.addCreature(swordmen1);

        Hero hero2 = new Hero("Hero2", "FractionOfHero2", 1, 1);
        Angel angels2 = new Angel(1, 11);
        Pikeman pikemen2 = new Pikeman(2, 20);
        Griffin griffins2 = new Griffin(3, 30);
        Swordman swordmen2 = new Swordman(4, 40);
        hero2.addCreature(angels2);
        hero2.addCreature(pikemen2);
        hero2.addCreature(griffins2);
        hero2.addCreature(swordmen2);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winningHero = battlefield.battle();

        assertEquals(hero2, winningHero);
    }
}