package school.faang.bjs2_61890;

import java.util.Arrays;
import java.util.List;

public class Music {

    public static void main(String[] args) {
        Player player = new Player(false);

        List<Thread> threads = Arrays.asList(
            new Thread(player::play),
            new Thread(player::skip),
            new Thread(player::pause),
            new Thread(player::previous)
        );

        for (Thread thread : threads) {
            thread.start();
        }
    }

}
