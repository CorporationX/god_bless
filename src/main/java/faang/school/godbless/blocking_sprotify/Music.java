package faang.school.godbless.blocking_sprotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(player::play);
        executorService.execute(player::pause);
        executorService.execute(player::skip);
        executorService.execute(player::play);
        executorService.execute(player::previous);

        executorService.shutdown();
    }
}
