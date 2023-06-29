package sprint4.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final Player player = new Player();
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        service.execute(player::play);
        service.execute(player::pause);
        service.execute(player::skip);
        service.execute(player::pause);
        service.execute(player::previous);

        service.shutdown();
    }
}
