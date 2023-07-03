package faang.school.godbless.starwars_arena;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public Future<Robot> fight(Robot robot1, Robot robot2){
         ExecutorService executor = Executors.newFixedThreadPool(2);

         Future<Robot> winner = executor.submit(() -> {
             int attackDifference = robot1.getAttackPower() - robot2.getAttackPower();

             if (attackDifference > 0){
                 return robot1;
             } else if (attackDifference < 0){
                 return robot2;
             } else {
                 if (robot1.getDefensePower() - robot2.getDefensePower() > 0){
                     return robot1;
                 } else {
                     return robot2;
                 }
             }});

         return winner;
    }

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            System.out.println("The winner is: " + winnerFuture.get().getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
