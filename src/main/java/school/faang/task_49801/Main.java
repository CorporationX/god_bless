package school.faang.task_49801;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<Thread> players = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Player player = new Player("Player" + i);
            Thread playerThread = new Thread(() -> player.startBattle(boss));
            players.add(playerThread);
            playerThread.start();
        }

        for (Thread thread : players) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("The main thread was interrupted");
            }
        }

        log.info("All players finished battle");
    }
}