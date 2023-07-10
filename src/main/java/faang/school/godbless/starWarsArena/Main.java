package faang.school.godbless.starWarsArena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        Robot robot1 = new Robot("Chappy", 5, 3, 7);
        Robot robot2 = new Robot("Monet", 6, 4, 4);
        Robot robot3 = new Robot("Praime", 7, 5, 4);
        Robot robot4 = new Robot("Boss", 9, 6, 3);

        Future<Robot> winnerFuture = battle.fight(robot1, robot2);
        Future<Robot> winner2Future = battle.fight(robot3, robot4);
        try {
            Robot winner = winnerFuture.get();
            Robot secondWinner = winner2Future.get();
            System.out.println("Победитель первой битвы: " + winner.getName());
            System.out.println("Победитель второй битвы: " + secondWinner.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
