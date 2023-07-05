package Multithreading.bc3041_Star_Wars_Arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Battle battle = new Battle();

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


}
