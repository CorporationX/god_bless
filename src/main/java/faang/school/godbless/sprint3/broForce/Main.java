package faang.school.godbless.sprint3.broForce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Bro bro1 = new Bro("Bro 1", 5);
        Bro bro2 = new Bro("Bro 2", 9);
        Bro bro3 = new Bro("Bro 3", 3);
        Bro bro4 = new Bro("Bro 4", 4);
        Bro bro5 = new Bro("Bro 5", 8);
        List<Bro> bros = new ArrayList<>(List.of(bro1, bro2, bro3, bro4, bro5));
        Game game = new Game(bros);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        game.getBros().forEach(bro -> executor.submit(() -> {
            while (game.isContinue()) {
                game.update(bro);
            }
        }));
        executor.shutdown();
    }
}
