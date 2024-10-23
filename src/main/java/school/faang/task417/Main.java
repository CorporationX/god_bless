package school.faang.task417;

import school.faang.task417.starwars.Battle;
import school.faang.task417.starwars.Robot;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot bb8 = new Robot("BB-8", 6, 6);

        Future<Robot> firstFight = Battle.fight(r2d2, c3po);
        Future<Robot> secondFight = Battle.fight(r2d2, bb8);
        Future<Robot> thirdFight = Battle.fight(c3po, bb8);

        try {
            System.out.println("Побежитель в первом поединке " + firstFight.get().getName());
            System.out.println("Побежитель во втором поединке " + secondFight.get().getName());
            System.out.println("Побежитель в третьем поединке " + thirdFight.get().getName());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
