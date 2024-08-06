package faang.school.godbless.BJS2_18911;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BattlefieldTest {

    private Hero redSide;
    private Hero blueSide;
    private Battlefield battlefield;

    @BeforeEach
    void setUp() {
        List<Creature> redArmy = new ArrayList<>(List.of(
                new Griffin(5),
                new Pikeman(4),
                new Pikeman(6),
                new Pikeman(3)
        ));
        redSide = new Hero("Robert", "FAANG", 213, 3, redArmy);

        List<Creature> blueArmy = new ArrayList<>(List.of(
                new Griffin(4),
                new Angel(1),
                new Pikeman(4),
                new Griffin(3),
                new Griffin(3)
        ));
        blueSide = new Hero("Amirhan", "FAANG", 646, 13, blueArmy);
        battlefield = new Battlefield(redSide, blueSide);
    }

    @Test
    void battle_Draw() {
        Hero result = battlefield.battle();

        assertNull(result);
    }

    @Test
    void battle_RedArmyWin() {
        Creature creature = new Griffin(7);
        redSide.addCreature(creature, 2);

        Hero result = battlefield.battle();

        assertEquals(redSide, result);
    }

    @Test
    void battle_BlueArmyWin() {
        Creature creature = new Griffin(7);
        blueSide.addCreature(creature, 2);

        Hero result = battlefield.battle();

        assertEquals(blueSide, result);
    }

    @Test
    void battle_EmptyArmies() {
        redSide.getArmy().clear();
        blueSide.getArmy().clear();

        Hero result = battlefield.battle();

        assertNull(result);
    }
}