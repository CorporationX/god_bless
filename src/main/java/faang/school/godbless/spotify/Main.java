package faang.school.godbless.spotify;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(List.of(
                "The Beatles - Hey Jude",
                "Queen - Bohemian Rhapsody",
                "Led Zeppelin - Stairway to Heaven",
                "Nirvana - Smells Like Teen Spirit",
                "Michael Jackson - Billie Jean",
                "AC/DC - Back in Black",
                "Eagles - Hotel California"
        ));

        Thread t1 = ThreadFactory.runnableProxy(() -> {
            player.play();
            player.skip();
        }, "User1");

        Thread t2 = ThreadFactory.runnableProxy(() -> {
            player.pause();
            player.play();
            player.skip();
            player.play();
        }, "User2");

        Thread t3 = ThreadFactory.runnableProxy(() -> {
            IntStream.range(0, 4).forEach(i -> player.skip());
            player.pause();
            player.play();
            player.previous();
        }, "User3");

        Stream.of(t1, t2, t3)
                .peek(Thread::start)
                .forEach(t -> {
                    try {
                        t.join();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println("Player actions consumed.");
    }

    private static class ThreadFactory {
        public static Thread runnableProxy(Runnable actions, String threadName) {
            return new Thread(() -> {
                System.out.printf("Passed control to user thread: '%s'%n%n", Thread.currentThread().getName());
                actions.run();
                System.out.println("--------------------");
            }, threadName);
        }
    }
}
