package school.faang.bjs249154.programm;

import school.faang.bjs249154.model.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final Player player = new Player(true, 0);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(player::play);
        executorService.submit(player::previous);
        executorService.submit(player::pause);
        executorService.submit(player::previous);
        executorService.submit(player::play);
        executorService.submit(player::previous);
        executorService.submit(player::skip);
        executorService.submit(player::pause);
        executorService.shutdown();
    }
}
