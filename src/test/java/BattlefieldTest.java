import faang.school.godbless.BJS218880.Angel;
import faang.school.godbless.BJS218880.Battlefield;
import faang.school.godbless.BJS218880.Creature;
import faang.school.godbless.BJS218880.Hero;
import faang.school.godbless.BJS218880.Pikeman;
import faang.school.godbless.BJS218880.Swordman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BattlefieldTest {
    private Battlefield battlefield;
    Hero protagonist;
    Hero antagonist;

    @BeforeEach
    void setUp() {
        Map<String, Creature> protagonistCreatures = new HashMap<>();
        protagonistCreatures.put("Pikeman", new Pikeman(3));
        protagonistCreatures.put("Angel", new Angel(5));
        protagonistCreatures.put("Griffin", new Swordman(2));

        Map<String, Creature> antagonistCreatures = new HashMap<>();
        antagonistCreatures.put("Pikeman", new Pikeman(3));
        antagonistCreatures.put("Angel", new Angel(5));
        antagonistCreatures.put("Griffin", new Swordman(2));
        this.protagonist = new Hero("Kyle", "White", 500, 10, protagonistCreatures);
        this.antagonist = new Hero("Rammon", "Dark", 600, 11, antagonistCreatures);
        this.battlefield = new Battlefield(protagonist, antagonist);
    }

    @Test
    void battle_drawnBattle() {
        assertNull(battlefield.battle());
    }

    @Test
    void battle_protagonistWinner() {
        protagonist.addCreature(new Swordman(5));
        assertEquals(protagonist, battlefield.battle());
    }

    @Test
    void battle_antagonistWinner() {
        antagonist.addCreature(new Angel(10));
        assertEquals(antagonist, battlefield.battle());
    }
}
