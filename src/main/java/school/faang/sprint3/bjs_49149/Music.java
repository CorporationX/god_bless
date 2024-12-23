package school.faang.sprint3.bjs_49149;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    public static void main(String[] args) {
        int totalActions = 7;
        int timeOut = 100;

        Random random = new Random();
        Player myPlayer = new Player();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < totalActions; i++) {
            int action = random.nextInt(4);
            switch (action) {
              case 0:
                  executor.submit(myPlayer::play);
                  break;
              case 1:
                  executor.submit(myPlayer::pause);
                  break;
              case 2:
                  executor.submit(myPlayer::skip);
                  break;
              default:
                  executor.submit(myPlayer::previous);
                  break;
            }
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(timeOut, TimeUnit.MILLISECONDS)) {
                log.error("Thread can't be finished");
            } else {
                log.info("All tasks completed");
            }
        } catch (InterruptedException e) {
            log.error("Unexpected interruption");
        } finally {
            executor.shutdownNow();
        }
    }
}
