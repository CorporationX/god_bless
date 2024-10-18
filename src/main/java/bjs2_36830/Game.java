package bjs2_36830;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("player1"),
                new Player("player2"),
                new Player("player3"),
                new Player("player4"),
                new Player("player5"),
                new Player("player6"),
                new Player("player7"),
                new Player("player8"),
                new Player("player9"),
                new Player("player10")
        );

        Boss boss = new Boss(4);

        players.forEach(player -> {
                    Thread joinThread = new Thread(() -> {
                        try {
                            player.startBattle(boss);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                    joinThread.start();

                    new Thread(() -> {
                        try {
                            joinThread.join();
                            boss.leaveBattle(player);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
        );
    }
}
