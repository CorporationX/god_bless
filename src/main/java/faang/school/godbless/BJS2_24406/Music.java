package faang.school.godbless.BJS2_24406;

import java.util.Arrays;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        List<Thread> threads = Arrays.asList(playThread, pauseThread, skipThread, previousThread);
        threads.forEach(Thread::start);
    }
}
