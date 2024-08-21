package faang.school.godbless.BJS2_24350;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) {
        Deque<String> musics = new LinkedList<>();
        musics.add("Robert");
        musics.add("Sultan");
        musics.add("Andrey");
        musics.add("Mukhail");

        Player player = new Player(musics);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(player::play);
        executor.execute(player::pause);
        executor.execute(player::skip);
        executor.execute(player::previous);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
