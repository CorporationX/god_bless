package faang.school.godbless.BJS2_24485;

import java.util.Arrays;
import java.util.List;

public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        List<Thread> threadList = Arrays.asList(
                new Thread(player::play, "play"),
                new Thread(player::pause, "pause"),
                new Thread(player::skip, "skip"),
                new Thread(player::previous, "previous"));

        threadList.forEach(Thread::start);
    }
}
