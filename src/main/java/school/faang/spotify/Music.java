package school.faang.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Danil Pudovkin
 * @since 17.06.2025
 */
public class Music {

    public static void main(String[] args) {
        var player = new Player();
        new Thread(player::play).start();
        new Thread(player::pause).start();
        new Thread(player::skip).start();
        new Thread(player::previous).start();
    }
}
