package school.faang.bjs2_37528;

import java.util.stream.Stream;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread threadPlay = new Thread(player::play);
        Thread threadPause = new Thread(player::pause);
        Thread threadSkip = new Thread(player::skip);
        Thread threadPrevious = new Thread(player::previous);

        Stream.of(threadPlay, threadPause, threadSkip, threadPrevious)
                .forEach(Thread::start);
    }

}
