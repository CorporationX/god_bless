package faang.school.godbless.synchronize.broForce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Bro> bros = new ArrayList<>();
        Bro bro1 = new Bro("Terminator", 0, 10, true);
        Bro bro2 = new Bro("Sara Connor", 0, 10, true);
        Bro bro3 = new Bro("Chack Norris", 0, 10, true);
        bros.add(bro1);
        bros.add(bro2);
        bros.add(bro3);

        Game game = new Game(bros);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(game::update);

        executorService.shutdown();
    }
}
