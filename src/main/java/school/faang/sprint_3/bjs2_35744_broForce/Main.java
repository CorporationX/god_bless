package school.faang.sprint_3.bjs2_35744_broForce;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Game game = new Game(9);
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(game::startGame);
        executor.shutdown();
    }
}
