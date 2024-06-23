package faang.school.godbless.synch1;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = getThreads(player);
        threads.forEach(Thread::start);
    }

    private static List<Thread> getThreads(Player player) {
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);
        return List.of(playThread, pauseThread, skipThread, previousThread);
    }
}
