package supercow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(2, 0);

        Player player1 = new Player("Max");
        Player player2 = new Player("James");
        Player player3 = new Player("Karla");
        Player player4 = new Player("Luiza");
        Player player5 = new Player("Gregory");
        Player player6 = new Player("Robert");

        List<Player> playersToJoin = new ArrayList<>(Arrays.asList(player1, player2, player3, player4, player5, player6));

        Thread joinThread = new Thread(() -> {
            try {
                for (Player player : playersToJoin) {
                    boss.joinBattle(player);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread battleThread = new Thread(() -> {
            try {
                while (!playersToJoin.isEmpty()) {
                    boss.startBattle();
                    Thread.sleep(1000);  // Добавим небольшую задержку перед новой битвой
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        joinThread.start();
        battleThread.start();

        joinThread.join();
        battleThread.join();
    }
}