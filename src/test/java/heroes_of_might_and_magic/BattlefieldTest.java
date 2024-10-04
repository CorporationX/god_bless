package heroes_of_might_and_magic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BattlefieldTest {
    static final Hero FIRST_HERO = new Hero("John", "Theif", 1, 5);
    static final Hero SECOND_HERO = new Hero("Jane", "Warrior", 10, 50);
    @BeforeEach
    void setUp() {
        Creature angel = new Angel("Angel", 5, 5, 5, 5);
        Creature griffin = new Griffin("Dragon", 5, 5, 5, 5);
        Creature pikeman = new Pikeman("Pikeman", 5, 5, 5, 5);
        Creature swordsman = new Swordman("Swordman", 5, 5, 5, 5);

        List<Creature> creatures = List.of(angel, griffin, pikeman, swordsman);

        for (Creature creature : creatures) {
            FIRST_HERO.addCreature(creature, 15);
            SECOND_HERO.addCreature(creature, 14);
        }
    }

    @AfterEach
    void tearDown() {
        FIRST_HERO.getArmy().clear();
        SECOND_HERO.getArmy().clear();
    }

    @Test
    void battle() {
        Battlefield battlefield = new Battlefield();
        Hero winner = battlefield.battle(FIRST_HERO, SECOND_HERO);

        assertEquals(FIRST_HERO, winner);
    }
}