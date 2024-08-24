package faang.school.godbless.BJS224316;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Starting game");

        Boss boss = new Boss(3);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Player player5 = new Player("Player5");

        Thread thread1 = new Thread(() -> {
            try {
                player1.startBattle(boss);
            } catch (InterruptedException e) {
                log.error("Thread 1 interrupted", e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                player2.startBattle(boss);
            } catch (InterruptedException e) {
                log.error("Thread 2 interrupted", e);
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                player3.startBattle(boss);
            } catch (InterruptedException e) {
                log.error("Thread 3 interrupted", e);
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                player4.startBattle(boss);
            } catch (InterruptedException e) {
                log.error("Thread 4 interrupted", e);
            }
        });

        Thread thread5 = new Thread(() -> {
            try {
                player5.startBattle(boss);
            } catch (InterruptedException e) {
                log.error("Thread 5 interrupted", e);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
