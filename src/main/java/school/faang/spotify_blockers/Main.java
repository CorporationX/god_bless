package school.faang.spotify_blockers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        List<Runnable> actions = Arrays.asList(
                (player::play),
                (player::stop),
                (player::skip),
                (player::previous));

        actions.forEach(action -> {
            new Thread(action).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        });
    }
}


