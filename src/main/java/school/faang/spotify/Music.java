package school.faang.spotify;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread previousThread = new Thread(player::previous);
        Thread skipThread = new Thread(player::skip);
        Thread pauseThread = new Thread(player::pause);
        Thread playThread1 = new Thread(player::play);
        List<Thread> threads = List.of(playThread1, playThread, previousThread, skipThread, pauseThread);
        threads.forEach(Thread::start);
    }
}
