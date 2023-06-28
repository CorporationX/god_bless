package finally_a_normal_game;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<PigThread> piglets = List.of(new Pig1Thread(), new Pig2Thread(), new Pig3Thread());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.submit(piglets.get(i));
        }
        executor.shutdown();
    }
}
