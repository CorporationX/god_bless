package faang.school.godbless.fourth.StarWars;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot biba = new Robot("Biba", 7, 4);
        Robot boba = new Robot("Boba", 5, 6);

        Future<Robot> futureWinner = battle.fight(biba, boba);

        try {
            Robot winner = futureWinner.get();
            System.out.println("Победитель битвы: " + winner.name());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Thread has been interrupted");
        }
    }
}
