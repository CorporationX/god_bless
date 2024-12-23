package school.faang.task_49196;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player(true);

        List<Runnable> playerList = new ArrayList<>();
        playerList.add(player::play);
        playerList.add(player::pause);
        playerList.add(player::skip);
        playerList.add(player::previous);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        playerList.forEach(executorService::submit);

        executorService.shutdown();

    }
}