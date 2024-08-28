package faang.school.godbless.BJS2_24204;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static Random random = new Random();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Game game = new Game(executor);
        List<Player> players = Arrays.asList(
                new Player("BoUnCiNgBaNaNa__", game),
                new Player("tHUnder_dumpling111", game),
                new Player("_pp_professional__2004", game)
        );

        players.stream()
                .map(Main::createTask)
                .forEach(executor::execute);
    }

    private static Runnable createTask(Player player) {
        return () -> {
            while (true) {
                try {
                    Thread.sleep((1 + random.nextInt(5)) * 1000);
                } catch (InterruptedException e) {
                    System.out.printf("Thread %S is interrupt\n", Thread.currentThread().getName());
                    return;
                }

                Runnable[] actions = {player::minusLive, player::plusPoint};
                actions[random.nextInt(2)].run();
            }
        };
    }
}
