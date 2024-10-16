package bjs2_37377;

import java.util.List;
import java.util.Random;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Random random = new Random();
        List<Runnable> actions = List.of(
                player::play,
                player::pause,
                player::skip,
                player::previous
        );

        for (int i = 0; i < 10; i++) {
            new Thread(actions.get(random.nextInt(actions.size()))).start();
        }
    }
}
