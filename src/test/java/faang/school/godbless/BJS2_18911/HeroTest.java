package faang.school.godbless.BJS2_18911;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeroTest {

    private Hero hero;

    @Test
    void constructorTest_ExperienceMore1000() {
        assertThrows(IllegalArgumentException.class, () ->
                new Hero("Robert", "Sber", 1001, 4));
    }

    @Test
    void constructorTest_ExperienceLess0() {
        assertThrows(IllegalArgumentException.class, () ->
                new Hero("Robert", "Sber", -1, 4));
    }

    @Test
    void constructorTest_LevelMore100() {
        assertThrows(IllegalArgumentException.class, () ->
                new Hero("Robert", "Sber", 123, 101));
    }

    @Test
    void constructorTest_LevelLess0() {
        assertThrows(IllegalArgumentException.class, () ->
                new Hero("Robert", "Sber", 123, -1));
    }

    @BeforeEach
    void setUp() {
        List<Creature> army = new ArrayList<>(List.of(
                new Pikeman(2),
                new Swordman(1),
                new Griffin(3),
                new Griffin(3)
        ));
        this.hero = new Hero("Robert", "Sber", 123, 4, army);
    }

    @Test
    void addCreature() {
        List<Creature> correctAnswer = List.of(
                new Pikeman(2),
                new Swordman(1),
                new Griffin(3),
                new Griffin(3),
                new Angel(2),
                new Angel(2)
        );

        hero.addCreature(new Angel(2), 2);

        assertEquals(correctAnswer, hero.getArmy());
    }

    @Test
    void addCreature_quantityZero() {
        assertThrows(IllegalArgumentException.class,
                () -> hero.addCreature(new Angel(2), 0));
    }

    @Test
    void removeCreature() {
        List<Creature> correctAnswer = List.of(
                new Pikeman(2),
                new Swordman(1),
                new Griffin(3)
        );

        hero.removeCreature(new Griffin(3), 1);

        assertEquals(correctAnswer, hero.getArmy());
    }

    @Test
    void removeCreature_deleteAllQuantity() {
        List<Creature> correctAnswer = List.of(
                new Pikeman(2),
                new Swordman(1)
        );

        hero.removeCreature(new Griffin(3), 2);

        assertEquals(correctAnswer, hero.getArmy());
    }

    @Test
    void removeCreature_FromEmptyListAndNoCreatureInList() {
        Hero hero = new Hero("Robert", "FAANG", 123, 3);
        List<Creature> correctAnswer = new ArrayList<>();

        hero.removeCreature(new Angel(2), 1);

        assertEquals(correctAnswer, hero.getArmy());
    }

    @Test
    void removeCreature_quantityZero() {
        assertThrows(IllegalArgumentException.class,
                () -> hero.removeCreature(new Angel(2), 0));
    }
}