package faang.school.godbless.task.might.and.magic.hero;

import faang.school.godbless.task.might.and.magic.creature.Angel;
import faang.school.godbless.task.might.and.magic.creature.Griffin;
import faang.school.godbless.task.might.and.magic.creature.Pikeman;
import faang.school.godbless.task.might.and.magic.creature.Swordman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattlefieldTest {
    private final Angel angel = new Angel("Angel", 1); // health: 30; damage: 46;
    private final Griffin griffin = new Griffin("Griffin", 1); // health: 67; damage: 16;
    private final Swordman swordman = new Swordman("Swordman", 1); // health: 43; damage: 25;
    private final Pikeman pikeman = new Pikeman("Pikeman", 1); // health: 43; damage: 30;

    private Hero heroA;
    private Hero heroB;
    private Battlefield battlefield;

    @BeforeEach
    void setUp() {
        battlefield = new Battlefield();
        heroA = new Hero("A", "A", 1.0, 1, new HashMap<>());
        heroB = new Hero("B", "B", 2.0, 2, new HashMap<>());
    }

    @Test
    void testBattle() {
        // healthA: 194; damageA: 124;
        heroA.addCreature(angel, 2);
        heroA.addCreature(griffin, 2);
        // healthB: 172; damageB: 110;
        heroB.addCreature(swordman, 2);
        heroB.addCreature(pikeman, 2);
        // healthA - damageB == 84; healthB - damageA == 48;
        assertEquals(heroA, battlefield.battle(heroA, heroB));
    }
}
