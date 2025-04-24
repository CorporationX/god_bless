package school.faang.bjs2_73172;

import java.util.List;

public class Music {

    private static final Player PLAYER = new Player();
    private static final List<Thread> THREADS = List.of(
            new Thread(PLAYER::pause),
            new Thread(PLAYER::play),
            new Thread(PLAYER::previous),
            new Thread(PLAYER::skip),
            new Thread(PLAYER::pause));

    public static void main(String[] args) {
        THREADS.forEach(Thread::start);
    }
}
