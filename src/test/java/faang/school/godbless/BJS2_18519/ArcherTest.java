package faang.school.godbless.BJS2_18519;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void attack() {
        Archer attack = new Archer("Mikhail");
        Archer defense = new Archer("Robert");
        int correctAnswer = 60;

        for (int i = 0; i < 4; i++) {
            attack.attack(defense);
        }
        int result = defense.getHitPoints();

        assertEquals(correctAnswer, result);
    }
}