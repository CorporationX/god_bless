package school.faang.block_spotify;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Music {
    public static void main(String[] args) {
        List<Integer> tracks = IntStream.range(0, 50).boxed().toList();
        Player player = new Player(tracks);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            switch (random.nextInt(4)) {
                case 0:
                    executor.execute(player::play);
                    break;
                case 1:
                    executor.execute(player::pause);
                    break;
                case 2:
                    executor.execute(player::previous);
                    break;
                case 3:
                    executor.execute(player::skip);
                    break;
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
            executor.shutdownNow();
        }
        System.out.println("End of the program");
    }
}
