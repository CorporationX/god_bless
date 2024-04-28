package faang.school.godbless.Task_23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Object lock = new Object();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> new Player(lock, "Song is playing").play());
        executorService.execute(() -> new Player(lock, "Music pause").pause());
        executorService.execute(() -> new Player(lock, "Song is skipped").skip());
        executorService.execute(() -> new Player(lock, "To previous song").previous());

        executorService.shutdown();
    }
}
