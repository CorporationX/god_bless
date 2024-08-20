package faang.school.godbless.BJS2_24024;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Chore> chores = Arrays.asList(
                new Chore("washing the dishes"),
                new Chore("daily cleaning of the house"),
                new Chore("grocery shopping")
        );
        chores.forEach(executor::submit);
        executor.shutdown();
    }
}
