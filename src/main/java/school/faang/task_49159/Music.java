package school.faang.task_49159;

import java.util.stream.Stream;

public class Music {
    private static final Player PLAYER = new Player();

    public static void main(String[] args) {
        Stream.of(
                new Thread(PLAYER::play),
                new Thread(PLAYER::pause),
                new Thread(PLAYER::skip),
                new Thread(PLAYER::previous)
        ).forEach(Thread::start);
    }

}
