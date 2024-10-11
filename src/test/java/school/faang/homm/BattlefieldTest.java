package school.faang.homm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class BattlefieldTest {

    private Battlefield battlefield;
    private Hero hero1;
    private Hero hero2;
    private Creature angel;
    private Creature pikeman;
    private Creature swordman;
    private Creature griffin;


    @BeforeEach
    public void setUp() {
        hero1 = new Hero("Hero 1", "Fraction 1", 100, 10, new HashMap<>());
        hero2 = new Hero("Hero 2", "Fraction 2", 200, 12, new HashMap<>());

        angel = new Angel();
        pikeman = new Pikeman();
        swordman = new Swordman();
        griffin = new Griffin();

        hero1.addCreature(angel, 10);
        hero1.addCreature(pikeman, 10);

        hero2.addCreature(swordman, 8);
        hero2.addCreature(griffin, 8);

        battlefield = new Battlefield(hero1, hero2);
    }

    @Test
    public void battleWinFirstHeroTest() {
        Hero result = battlefield.battle();
        assertEquals(hero1, result);
    }

    @Test
    public void battleWinSecondHeroTest() {
        hero2.addCreature(angel, 5);
        assertEquals(hero2, battlefield.battle());
    }

    @Test
    public void battleEmptyArmyTest() {
        hero1.removeCreature(angel, 10);
        hero1.removeCreature(pikeman, 10);
        assertEquals(0, hero1.getArmy().size());
        assertEquals(hero2, battlefield.battle());
    }
}
