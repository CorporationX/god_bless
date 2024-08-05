package faang.school.godbless.BJS2_18519;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarriorTest {

    @Test
    void attack() {
        Warrior attack = new Warrior("Mikhail");
        Warrior defense = new Warrior("Robert");
        int correctAnswer = 60;

        for (int i = 0; i < 4; i++) {
            attack.attack(defense);
        }
        int result = defense.getHitPoints();

        assertEquals(correctAnswer, result);
    }
}