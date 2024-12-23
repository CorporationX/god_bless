package school.faang.sprint3.task_bjs249278;

import java.util.Arrays;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> threads = Arrays.asList(
                new Thread(player::play),
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        );

        threads.forEach(Thread::start);
    }
}
