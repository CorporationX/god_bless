package school.faang.bjs2_63700;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = List.of(
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous),
                new Thread(player::play)
        );
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
