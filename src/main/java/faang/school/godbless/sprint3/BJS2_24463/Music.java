package faang.school.godbless.sprint3.BJS2_24463;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> playerThreads = new ArrayList<>(List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        ));

        playerThreads.forEach(Thread::start);
    }
}
