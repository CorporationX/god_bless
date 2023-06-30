package Sprint_4_Task17;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        Player player = new Player("Олег");
        Player player2 = new Player("Дмитрий");
        Player player3 = new Player("Роман");
        Player player4 = new Player("Никита");
        Player player5 = new Player("Кирилл");
        Player player6 = new Player("Виктор");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> {boss.joinBattle(player);});
        executor.submit(() -> {boss.joinBattle(player2);});
        executor.submit(() -> {boss.joinBattle(player3);});
        executor.submit(() -> {boss.joinBattle(player4);});
        executor.submit(() -> {boss.joinBattle(player5);});
        executor.submit(() -> {boss.joinBattle(player6);});
        executor.submit(() -> {boss.liftBattle(player6);});
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("Done");
    }
}
