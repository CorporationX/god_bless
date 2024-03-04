package faang.school.godbless.BJS2_3238;

import java.util.ArrayList;
import java.util.List;

public class Music {
    private static final int REPEATS_NUMBER = 20;

    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = new ArrayList<>(4);
        for (int i = 0; i < REPEATS_NUMBER; ++i) {
            Thread playThread = new Thread(player::play);
            threads.add(playThread);
            Thread pauseThread = new Thread(player::pause);
            threads.add(pauseThread);
            Thread skipThread = new Thread(player::skip);
            threads.add(skipThread);
            Thread previousThread = new Thread(player::previous);
            threads.add(previousThread);
        }
        threads.forEach(Thread::start);

    }
}
