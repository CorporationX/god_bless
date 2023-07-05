package faang.school.godbless.multithreading.star_wars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleTest {
    private Battle battle;

    @BeforeEach
    void setUp() {
        battle = new Battle();
    }

    @Test
    void fight_shouldPrintRandomRobot() {
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner = winnerFuture.get();
            System.out.println("Победитель битвы: " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    void fight_winnerShouldMatch() {
        Robot r1 = new Robot("R1", 10, 15);
        Robot r2 = new Robot("R2", 10, 10);

        Future<Robot> winnerFuture1 = battle.fight(r1, r2);

        Robot r3 = new Robot("R3", 10, 10);
        Robot r4 = new Robot("R4", 10, 5);

        Future<Robot> winnerFuture2 = battle.fight(r3, r4);

        try {
            assertEquals(r1, winnerFuture1.get());
            assertEquals(r3, winnerFuture2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}