package school.faang.task49501;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
public class Music {

    private static final Random RANDOM = new Random();
    private static final Integer AMOUNT = 8;

    public static void main(String[] args) {


        Player player = new Player();
        List<Thread> threads = getTestThreads(player, AMOUNT);
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread {} was interrupted ", thread);
                Thread.currentThread().interrupt();
            }
        }
        log.info("Total threads worked {} ", player.getCountThreads().get());

    }

    private static List<Thread> getTestThreads(Player player, Integer amount) {

        return IntStream.range(0, amount)
                .mapToObj(i -> new Thread(() -> {
                    int action = RANDOM.nextInt(4);
                    switch (action) {
                      case 0 -> player.play();

                      case 1 -> player.pause();

                      case 2 -> player.skip();

                      case 3 -> player.previous();

                      default -> throw new IllegalStateException("Unexpected value :"
                                + action);
                    }
                }))
                .toList();
    }

}

