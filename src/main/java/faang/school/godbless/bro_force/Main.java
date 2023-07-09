package faang.school.godbless.bro_force;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Bro rambo = new Bro("Rambo", 6);
        Bro roboCop = new Bro("RoboCop", 9);
        game.addBro(rambo);
        game.addBro(roboCop);


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < game.getBros().size(); i++) {
            int broInd = i;
            executorService.submit(() -> {
                while (rambo.getBroLives() > 0 && roboCop.getBroLives() > 0) {
                    boolean isRunning = game.update();
                }
            });
        }
    }
}
