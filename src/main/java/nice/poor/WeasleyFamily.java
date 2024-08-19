package nice.poor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"wash dishes", "clean house", "cook food", "do laundry"};
        try (ExecutorService executor = Executors.newCachedThreadPool()) {
            Arrays.stream(chores).forEach(c -> executor.execute(new Chore(c)));
            executor.shutdown();
        }
    }
}
