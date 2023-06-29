package sprint4.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static final Player PLAYER = new Player();
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);

        service.execute(PLAYER::play);
        service.execute(PLAYER::pause);
        service.execute(PLAYER::skip);
        service.execute(PLAYER::pause);
        service.execute(PLAYER::previous);

        service.shutdown();
    }
}
