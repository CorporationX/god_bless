package school.faang.starwars_arena.main;

import school.faang.starwars_arena.main_code.Battle;
import school.faang.starwars_arena.main_code.Robot;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 5, 7);
        Robot c3po = new Robot("C-3PO", 4, 8);

        Future<Robot> winnerFuture = battle.fight(r2d2, c3po);

        try {
            Robot winner  = winnerFuture.get();
            System.out.println("Робот победитель " + winner.getName());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Ошибка при попытке выявить победителя " + e);
        }

        battle.shutdown();
    }
}