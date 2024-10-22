package school.faang.starwarsarena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class StarWarsArena {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        Future<Robot> winnerFuture1 = battle.fight(r2d2, c3po);
        Future<Robot> winnerFuture2 = battle.fight(c3po, bb8);
        Future<Robot> winnerFuture3 = battle.fight(r2d2, bb8);

        try {
            Robot winner1 = winnerFuture1.get();
            System.out.println("The winner of the first battle is: " + winner1.getName());

            Robot winner2 = winnerFuture2.get();
            System.out.println("The winner of the second battle is: " + winner2.getName());

            Robot winner3 = winnerFuture3.get();
            System.out.println("The winner of the third battle is: " + winner3.getName());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

