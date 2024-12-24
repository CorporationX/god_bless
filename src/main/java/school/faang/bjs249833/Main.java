package school.faang.bjs249833;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static final int MAX_PLAYERS = 2;

    public static void main(String[] args) {

        Boss boss = new Boss(MAX_PLAYERS);

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");

        Thread thread1 = new Thread(() -> {
            try {
                player1.startBattle(boss);
            } catch (InterruptedException ex) {
                log.error("Battle start error, player1!");
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                player2.startBattle(boss);
            } catch (InterruptedException e) {
                log.error("Battle start error, player2!");
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                player3.startBattle(boss);
            } catch (InterruptedException e) {
                log.error("Battle start error, player3!");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
