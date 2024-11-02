package school.faang.thread4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Music {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Player spotifyMusic = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Callable<String>> actions = new ArrayList<>();
        actions.add(() -> spotifyMusic.play());
        actions.add(() -> spotifyMusic.pause());
        actions.add(() -> spotifyMusic.skip());
        actions.add(() -> spotifyMusic.previous());

        List<Future<String>> results = executor.invokeAll(actions);

        for (Future<String> result : results) {
            System.out.println("Thread result: " + result.get());
        }
        executor.shutdown();

    }
}
