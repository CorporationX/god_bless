package school.faang.bjs249600;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    private static final int MAX_PLAYERS = 3;

    public static void main(String[] args) {

        Boss boss = new Boss(MAX_PLAYERS);
        Player player1 = new Player("Plo");
        Player player2 = new Player("Klu");
        Player player3 = new Player("Tly");
        Player player4 = new Player("Nlt");
        List<Player> players = Arrays.asList(player1, player2, player3, player4);

        Thread thread1 = new Thread(() -> players.forEach(player -> player.startBattle(boss)));
        Thread thread2 = new Thread(() -> boss.leaveBattle(player1));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            log.error("The thread was interrupted {}", e.getMessage());
        }

        log.info("The battle is completed!");
    }
}
