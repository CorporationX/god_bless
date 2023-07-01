package faang.school.godbless.supercow;

import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss("boss", 2);

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        player1.startBattle(boss);
        player2.startBattle(boss);
        player3.startBattle(boss);
    }
}
