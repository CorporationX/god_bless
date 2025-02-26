package school.faang.bjs2_61890;

import java.util.Arrays;
import java.util.List;

public class Music {

    public static void main(String[] args) {
        Player player = new Player(false);

        List<Thread> threads = Arrays.asList(
                new Thread(player::play),
                new Thread(player::skip),
                new Thread(player::pause),
                new Thread(player::previous)
        );

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
