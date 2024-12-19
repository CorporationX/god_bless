package school.faang.sprint_3.task_bjs249193;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final Random RANDOM = new Random();
    public static final Integer THREAD_AMOUNT = 10;

    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> threads = getTestThreads(player, THREAD_AMOUNT);
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread {} was interrupted", thread);
                Thread.currentThread().interrupt();
            }
        }
        log.info("Total threads worked {}", player.getCountThreads().get());
    }

    private static List<Thread> getTestThreads(Player player, int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Thread(() -> {
                    int action = RANDOM.nextInt(4);
                    switch (action) {
                      case 0 -> player.pause();
                      case 1 -> player.play();
                      case 2 -> player.skip();
                      case 3 -> player.previous();
                      default -> throw new IllegalStateException("Unexpected value: " + action);
                    }
                }))
                .toList();
    }
}
