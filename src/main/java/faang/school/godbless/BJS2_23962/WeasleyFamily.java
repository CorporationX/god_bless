package faang.school.godbless.BJS2_23962;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"wash the dishes", "cleaning", "do smth else"};
        ExecutorService service = Executors.newCachedThreadPool();

        Arrays.stream(chores).forEach(chore -> service.execute(() -> new Chore(chore).run()));

        service.shutdown();
    }
}
