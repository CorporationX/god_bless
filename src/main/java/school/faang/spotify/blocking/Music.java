package school.faang.spotify.blocking;

import java.util.List;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();
        Thread threadPlay = new Thread(player::play);
        Thread threadPause = new Thread(player::pause);
        Thread threadSkip = new Thread(player::skip);
        Thread threadPrevious = new Thread(player::previous);
        List<Thread> threads = List.of(threadPlay, threadPause, threadSkip, threadPrevious);

        threads.forEach(Thread::start);
    }
}
