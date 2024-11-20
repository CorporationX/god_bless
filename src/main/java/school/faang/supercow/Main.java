package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Boss mainCow = new Boss(2);

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");

        Thread thread1 = new Thread(() -> {
            try {
                player1.startBattle(mainCow);
            } catch (InterruptedException e) {
                log.error("Exception in Threads connected to wait() method", e);
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                player2.startBattle(mainCow);
            } catch (InterruptedException e) {
                log.error("Exception in Threads connected to wait() method", e);
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                player3.startBattle(mainCow);
            } catch (InterruptedException e) {
                log.error("Exception in Threads connected to wait() method", e);
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}