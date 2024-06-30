package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Player playerOne = new Player("Ali");
        Player playerTwo = new Player("Alex");
        Player playerThree = new Player("John");
        Player playerFour = new Player("Max");
        List<Player> players = List.of(playerOne,playerTwo,playerThree,playerFour);
        Boss boss = new Boss(3);
        ExecutorService service = Executors.newFixedThreadPool(2);
        players.forEach(player -> {
                service.submit(()->{
                    try {
                        player.startBattle(boss);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
        });
        service.shutdown();
    }
}
