package faang.school.godbless.Multitrading2.Spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            service.execute(player::play);
            service.execute(player::pause);
            service.execute(player::previous);
            service.execute(player::skip);
        }
        service.shutdown();
    }
}
