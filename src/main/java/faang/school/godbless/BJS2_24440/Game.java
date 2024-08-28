package faang.school.godbless.BJS2_24440;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        List<Player> playerList = Arrays.asList(
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4"),
                new Player("Player 5"));
        List<Thread> threads = playerList.stream()
                .map(player -> new Thread(() -> player.startBattle(boss)))
                .peek(Thread::start)
                .toList();

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Что-то пошло не так");
            }
        });
        System.out.println("Все игроки вышли из игры.");
    }
}
