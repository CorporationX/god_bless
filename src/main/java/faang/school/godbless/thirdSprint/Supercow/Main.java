package faang.school.godbless.thirdSprint.Supercow;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Ubivator228");
        Player player2 = new Player("Zadrot");
        Player player3 = new Player("4u4elo");
        Player player4 = new Player("Monkey");
        List<Player> players = List.of(player1, player2, player3, player4);

        Boss boss = new Boss(2);

        Thread thread1 = new Thread(() -> {
            for (Player player : players) {
                player.startBattle(boss);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (Player player : players) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                player.finishBattle(boss);
            }
        });

        thread1.start();
        thread2.start();
    }
}
