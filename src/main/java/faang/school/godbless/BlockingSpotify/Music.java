package faang.school.godbless.BlockingSpotify;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> callThread = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous));

        callThread.forEach(Thread::start);
    }
}
