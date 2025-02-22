package bjs261657;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class Music {
    private static final int JOIN_DELAY_MS = 5000;

    public static void main(String[] args) {
        Player player = new Player();
        List<String> compositions = player.getCompositions();
        compositions.add("Composition1");
        compositions.add("Composition2");
        compositions.add("Composition3");
        compositions.add("Composition4");
        List<Thread> threads =
                Stream.of(getThreads(() -> {
                    try {
                        player.play();
                    } catch (InterruptedException e) {
                        log.error("Thread {} started, but not finished due to InterruptedException",
                                Thread.currentThread().getName(), new MusicException("InterruptedException", e));
                    }
                }, 2),
                getThreads(() -> {
                    try {
                        player.pause();
                    } catch (InterruptedException e) {
                        log.error("Thread {} started, but not finished due to InterruptedException",
                                Thread.currentThread().getName(), new MusicException("InterruptedException", e));
                    }
                }, 2),
                getThreads(() -> {
                    try {
                        player.skip();
                    } catch (InterruptedException e) {
                        log.error("Thread {} started, but not finished due to InterruptedException",
                                Thread.currentThread().getName(), new MusicException("InterruptedException", e));
                    }
                }, 2),
                getThreads(() -> {
                    try {
                        player.previous();
                    } catch (InterruptedException e) {
                        log.error("Thread {} started, but not finished due to InterruptedException",
                                Thread.currentThread().getName(), new MusicException("InterruptedException", e));
                    }
                }, 2)
        ).flatMap(Collection::stream).toList();

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join(JOIN_DELAY_MS);
            } catch (InterruptedException e) {
                log.error("Thread {} started, but not finished due to InterruptedException",
                        Thread.currentThread().getName(), new MusicException("InterruptedException", e));
            }
        });
    }

    private static List<Thread> getThreads(Runnable task, int threadsNumber) {
        return IntStream.rangeClosed(1, threadsNumber).boxed()
                .map(i -> new Thread(task))
                .toList();
    }

    private static <T, R> Function<T, R> wrapException(Function<T, R> functionWithException) {
        return arg -> {
            try {
                return functionWithException.apply(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
