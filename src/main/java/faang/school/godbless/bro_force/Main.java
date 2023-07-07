package faang.school.godbless.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Game game = new Game();
        for (int i = 0; i < 6; i++){
            executorService.execute(game::update);
        }

        executorService.shutdown();
    }
}
