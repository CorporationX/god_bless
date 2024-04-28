package faang.school.godbless.Task_26;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Bro> bros = new ArrayList<>(List.of(
                new Bro("Brommando", 3),
                new Bro("Brodator", 4)
        ));
        Game game = new Game(bros);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < bros.size(); i++) {
            executorService.execute(game::update);
        }
        executorService.shutdown();
    }
}
