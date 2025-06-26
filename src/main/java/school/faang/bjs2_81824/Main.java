package school.faang.bjs2_81824;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous)
        );

        for (Thread thread : threads) {
            thread.start();
        }
    }
}