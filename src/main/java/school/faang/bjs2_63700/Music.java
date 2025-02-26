package school.faang.bjs2_63700;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Music {
    private static List<Thread> THREADS = new ArrayList<>();

    public static void main(String[] args) {
        Player player = new Player();
        THREADS = List.of(
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::previous),
                new Thread(player::play)
        );

        for (Thread thread : THREADS) {
            thread.start();
        }

        for (Thread thread : THREADS) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Ошибка при ожидании потока", e);
                throw new RuntimeException("Ошибка при ожидании потока", e);
            }
        }
    }
}
