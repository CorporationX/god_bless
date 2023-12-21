package Supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();

        Player player1 = new Player("Alex", boss);
        Player player2 = new Player("Hero", boss);
        Player player3 = new Player("Cheater", boss);
        Player player4 = new Player("Hitman", boss);


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(boss);
        executorService.submit(player1);
        executorService.submit(player2);
        executorService.submit(player3);
        executorService.submit(player4);
    }
}
