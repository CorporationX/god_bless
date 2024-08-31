package faang.school.godbless.starwarsarena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot terminator = new Robot("Terminator", 8, 6);
        Robot optimusPrime = new Robot("Optimus Prime", 7, 9);

        Future<Robot> winnerFuture1 = Battle.fight(r2d2, c3po);
        Future<Robot> winnerFuture2 = Battle.fight(terminator, optimusPrime);

        try {
            Robot winner1 = winnerFuture1.get();
            System.out.println("Победитель битвы: " + winner1.getName());

            Robot winner2 = winnerFuture2.get();
            System.out.println("Победитель битвы: " + winner2.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            Battle.shutdown();
        }
    }
}

