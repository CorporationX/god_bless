package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    public static void main(String[] args) {
        BluetoothPlayer lock = new BluetoothPlayer();
        Player playThread = new Player(lock);
        Player pauseThread = new Player(lock);
        Player skipThread = new Player(lock);
        Player previousThread = new Player(lock);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> {
            playThread.play();
        });
        executorService.submit(() -> {
            pauseThread.pause();
        });
        executorService.submit(() -> {
            skipThread.skip();
        });
        executorService.submit(() -> {
            previousThread.previous();
        });

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)){
                log.info("finished fine");
            }else {
                log.info("finished non fine");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
