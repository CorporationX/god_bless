package school.faang.multithreading.sinchronized.bjs2_90236;

import java.util.List;
import java.util.Random;

public class Music {
    private static final int NUMBER_OF_ACTIONS = 15;
    private static final int NUMBER_OF_TREADS = 4;

    public static void main(String[] args) {
        Player player = new Player();

        List<Runnable> players = List.of(
                player::play,
                player::pause,
                player::skip,
                player::previous
        );

        Thread[] threads = new Thread[NUMBER_OF_TREADS];
        Random random = new Random();
        for (int i = 0; i < NUMBER_OF_ACTIONS; i++) {
            for (int j = 0; j < NUMBER_OF_TREADS; j++) {
                threads[j] = new Thread(players.get(random.nextInt(4)));
                threads[j].start();
            }
        }
    }
}
