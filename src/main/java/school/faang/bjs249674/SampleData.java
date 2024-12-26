package school.faang.bjs249674;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SampleData {
    static List<Player> players = Collections.synchronizedList(new ArrayList<>());

    @SneakyThrows
    public static void main(String[] args) {
        Boss boss = new Boss(10);
        init();
        System.out.println(players);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        players.forEach(player -> executor.execute(() -> {
            try {
                player.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    private static void init() {
        IntStream.range(0, 20).forEach(i -> players.add(new Player(Integer.toString(i))));
    }
}
