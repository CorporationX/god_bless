package faang.school.godbless.BJS2_24258;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Game {
    public static final int PLAYER_IN_GAME = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(PLAYER_IN_GAME);
        Player playerOne  = new Player("ThunderDumpling69", boss);
        Player playerTwo = new Player("__Flying_Cucumber_2004__", boss);
        Player playerThree = new Player("сat_vacuum_master", boss);
        Player playerFour = new Player("BoUnCiNgBaNaNa", boss);

        Runnable taskOne = () -> {
            playerOne.startBattle();
            sleepWithCatchException(5000);
            playerOne.endBattle();
        };

        Runnable taskTwo = () -> {
            playerTwo.startBattle();
            sleepWithCatchException(3000);
            playerTwo.endBattle();
        };

        Runnable taskThree = () -> {
            sleepWithCatchException(1000);
            playerThree.startBattle();
        };

        Runnable taskFour = () -> {
            sleepWithCatchException(1000);
            playerFour.startBattle();
        };

        ExecutorService executor = Executors.newFixedThreadPool(PLAYER_IN_GAME);
        executor.execute(taskOne);
        executor.execute(taskTwo);
        executor.execute(taskThree);
        executor.execute(taskFour);
        executor.shutdown();
    }

    public static void sleepWithCatchException(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleep error");
        }
    }
}
