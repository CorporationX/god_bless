package faang.school.godbless.Sprint5_1.tast2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 10);
        Robot c3po = new Robot("C-3PO", 5, 10);

        Robot robocop = new Robot("RoboCop", 10, 50);
        Robot terminator = new Robot("Terminator", 10, 50);

        Robot bumblebee = new Robot("Bumblebee", 10, 50);
        Robot megatron = new Robot("Megatron", 10, 50);


        Future<Robot> winnerFuture1 = battle.fight(r2d2, c3po);
        Future<Robot> winnerFuture2 = battle.fight(robocop, terminator);
        Future<Robot> winnerFuture3 = battle.fight(bumblebee, megatron);

        try {
            Robot winner1 = winnerFuture1.get();
            Robot winner2 = winnerFuture2.get();
            Robot winner3 = winnerFuture3.get();
            System.out.println("Победитель битвы №1: " + winner1.getName());
            System.out.println("Победитель битвы №2: " + winner2.getName());
            System.out.println("Победитель битвы №3: " + winner3.getName());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        battle.executor.shutdown();
    }
}
