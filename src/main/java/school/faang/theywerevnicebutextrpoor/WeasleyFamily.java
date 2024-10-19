package school.faang.theywerevnicebutextrpoor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = Arrays.asList("wash the dishes", "sweep the floor", "cook dinner", "do the laundry", "fix the furniture");

        ExecutorService executor = Executors.newCachedThreadPool();

        chores.stream()
                .map(Chore::new)
                .forEach(executor::execute);

        executor.shutdown();
    }
}

