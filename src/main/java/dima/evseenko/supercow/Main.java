package dima.evseenko.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);

        List<Thread> threads = new ArrayList<>();

        getPlayers().forEach((player -> {
            Thread thread = new Thread(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Ошибка присоединения %s к сражению!".formatted(player.getName()), e);
                }
            });
            threads.add(thread);
            thread.start();
        }));

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Сражение завершено!");
    }

    private static List<Player> getPlayers() {
        return List.of(
                new Player("Dima"),
                new Player("Vasya"),
                new Player("Kolya"),
                new Player("Edik"),
                new Player("Sasha"),
                new Player("Masha")
        );
    }
}
