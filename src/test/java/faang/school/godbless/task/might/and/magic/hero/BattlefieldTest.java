package faang.school.godbless.task.might.and.magic.hero;

import faang.school.godbless.task.hashmap.might.and.magic.creature.Angel;
import faang.school.godbless.task.hashmap.might.and.magic.creature.Creature;
import faang.school.godbless.task.hashmap.might.and.magic.creature.Griffin;
import faang.school.godbless.task.hashmap.might.and.magic.creature.Pikeman;
import faang.school.godbless.task.hashmap.might.and.magic.creature.Swordman;
import faang.school.godbless.task.hashmap.might.and.magic.hero.Battlefield;
import faang.school.godbless.task.hashmap.might.and.magic.hero.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
        battlefield = new Battlefield(new Random());
        heroA = new Hero("Akhiles", "A", 1.0, 7, new HashMap<>());
        heroB = new Hero("Borat", "B", 2.0, 5, new HashMap<>());

        heroA.addCreature(angel, 2);
        heroA.addCreature(griffin, 2);
        heroB.addCreature(swordman, 2);
        heroB.addCreature(pikeman, 2);
    }

    @Test
    @DisplayName("Test all show methods")
    void testShows() {
        battlefield.showAttack(angel, griffin);
        battlefield.showHealthAndDamage(angel);
        battlefield.showHeroAndArmy(heroA);
    }

    @Test
    @DisplayName("Calculate damage test")
    void testCalculateDamage() {
        System.out.println(angel);
        battlefield.calculateDamage(heroA, angel, swordman);
        System.out.println(angel);
    }

    @Test
    @DisplayName("Apply damage test")
    void testApplyDamage() {
        System.out.println(angel);
        battlefield.applyDamage(angel, 13.6);
        System.out.println(angel);
    }

    @Test
    @DisplayName("Remove lose creature test")
    void testRemoveLoseCreatures() {
        battlefield.showHeroAndArmy(heroA);
        List<Creature> army = heroA.getArmy();
        battlefield.applyDamage(army.get(0), 30);
        battlefield.showHeroAndArmy(heroA);
        battlefield.removeLoseCreatures(army.get(0), army);
        battlefield.showHeroAndArmy(heroA);
    }

    @Test
    @DisplayName("Test battle")
    void testBattle() {
        System.out.println("\nПобедил: " + battlefield.battle(heroA, heroB).getName());
    }
}
