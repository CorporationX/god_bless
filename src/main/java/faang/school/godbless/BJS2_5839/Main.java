package faang.school.godbless.BJS2_5839;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Player player1 = new Player("ninja turtle");
        Player player2 = new Player("Knight");
        Player player3 = new Player("Batman");
        Player player4 = new Player("Robbin");
        Player player5 = new Player("Robocop");
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);

        Boss boss = new Boss(3, players);
        Thread threadPlayer1StartFight = new Thread(() -> player1.startBattle(boss));
        Thread threadPlayer2StartFight = new Thread(() -> player2.startBattle(boss));
        Thread threadPlayer3StartFight = new Thread(() -> player3.startBattle(boss));
        Thread threadPlayer4StartFight = new Thread(() -> player4.startBattle(boss));
        Thread threadPlayer5StartFight = new Thread(() -> player4.startBattle(boss));
        Thread threadPlayer1StopFight = new Thread(() -> player1.stopFight(boss));
        Thread threadPlayer2StopFight = new Thread(() -> player2.stopFight(boss));
        Thread threadPlayer3StopFight = new Thread(() -> player3.stopFight(boss));
        Thread threadPlayer4StopFight = new Thread(() -> player4.stopFight(boss));
        Thread threadPlayer5StopFight = new Thread(() -> player5.stopFight(boss));

        threadPlayer1StartFight.start();
        threadPlayer2StartFight.start();
        threadPlayer3StartFight.start();
        threadPlayer4StartFight.start();
        threadPlayer5StartFight.start();
        threadPlayer1StopFight.start();
        threadPlayer2StopFight.start();
        threadPlayer3StopFight.start();
        threadPlayer4StopFight.start();
        threadPlayer5StopFight.start();
    }
}
