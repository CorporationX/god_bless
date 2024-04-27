package faang.school.godbless.starWarsArena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Robot firstRobot = new Robot("Red", 10, 20);
        Robot secondRobot = new Robot("Blue", 5, 25);
        Battle battle = new Battle();

        Future<Robot> winner = battle.fight(firstRobot, secondRobot);
        System.out.println(winner.get().getName());
    }
}
