package school.faang.Multithreading.sprint_3.Supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player witch = new Player("Ведьма");
        Player archer = new Player("Лучник");
        Player mage = new Player("Маг");
        Player swordsman = new Player("Мечник");

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(() -> witch.startBattle(boss));;
        executor.execute(() -> archer.startBattle(boss));
        executor.execute(() -> mage.startBattle(boss));
        executor.execute(() -> swordsman.startBattle(boss));

        executor.shutdown();

        try {
            if(executor.awaitTermination(20, TimeUnit.SECONDS)){
                System.out.println("Сражение закончилось");
            }else {
                System.out.println("Игроки не смогли победить в течении заданного времени");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Операция была прервана  " + e.getMessage());
            e.printStackTrace();
            executor.shutdownNow();
        }
    }
}
