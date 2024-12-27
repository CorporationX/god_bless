package school.faang.task_49357;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Runnable> tasks = List.of(player::play,
                player::play,
                player::pause,
                player::pause,
                player::skip,
                player::previous);
        List<Thread> threads = new ArrayList<>();

        for (Runnable task : tasks) {
            threads.add(new Thread(task));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}