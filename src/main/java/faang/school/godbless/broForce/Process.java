package faang.school.godbless.broForce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Process {
    public static void main(String[] args) {
        Game game = new Game(new ArrayList<>(List.of(
                new Person("Biba"),
                new Person("Boba"),
                new Person("BratBoba"),
                new Person("BratBiba")
        )));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> {
            while (true) {
                game.update();
            }
        });
        executorService.shutdown();

    }
}
