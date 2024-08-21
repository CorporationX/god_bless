package faang.school.godbless.BJS2_24381;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        while (true) {
            executor.execute(player::play);
            executor.execute(player::pause);
            executor.execute(player::skip);
            executor.execute(player::previous);
        }



//        try {
//            Thread.sleep(60000);
//            executor.shutdown();
//            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
//                executor.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }
}
