package faang.school.godbless.multithreading.spotify;

import java.util.List;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        addThreadsToList(player);
        worksThread(player);
        completeThread(player);
    }

    public static List<Thread> addThreadsToList(Player player) {
        List<Thread> threads = List.of(new Thread(player::pause), new Thread(player::skip),
                new Thread(player::play), new Thread(player::previous));
        return threads;
    }

    public static void worksThread(Player player) {
        addThreadsToList(player).stream()
                .forEach(Thread::start);
    }

    public static void completeThread(Player player) {
        addThreadsToList(player).stream()
                .forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Thread interrupted");
                    }
                });
    }
}
