package school.faang.multithreading.sinchronized.bjs2_90236;

import java.util.List;
import java.util.Random;

public class Music {
    private static final int NUMBER_OF_ACTIONS = 15;

    public static void main(String[] args) {
        Player player = new Player();

        List<Runnable> players = List.of(
                player::play,
                player::pause,
                player::skip,
                player::previous
        );

        Random random = new Random();
        for (int i = 0; i < NUMBER_OF_ACTIONS; i++) {
            Thread thread = new Thread(players.get(random.nextInt(4)));
            thread.start();
        }
    }
}
