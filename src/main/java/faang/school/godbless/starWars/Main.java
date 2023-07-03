package faang.school.godbless.starWars;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 6, 4);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        System.out.println("Battle has started!");

        try {
            winnerFuture.get();
            System.out.println("The battle is over!");
        } catch (InterruptedException e) {
            System.err.println("The battle was interrupted!");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.err.println("An error occurred during the battle!");
            e.printStackTrace();
        }

        battle.shutdown();
    }

}
