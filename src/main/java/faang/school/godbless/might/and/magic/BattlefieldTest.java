package faang.school.godbless.might.and.magic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattlefieldTest {

    @Test
    void testBattle() {
        Hero hero1 = new Hero("Knight", "Castle", 1000, 5);
        Hero hero2 = new Hero("Barbarian", "Stronghold", 1000, 5);
        hero1.addCreature(new Pikeman(50), 50);
        hero1.addCreature(new Griffin(20), 20);
        hero2.addCreature(new Swordman(30), 30);
        hero2.addCreature(new Angel(10), 10);
        Battlefield battlefield = new Battlefield(hero1, hero2);

        Hero winner = battlefield.battle();

        assertEquals(hero2, winner);

    }

}