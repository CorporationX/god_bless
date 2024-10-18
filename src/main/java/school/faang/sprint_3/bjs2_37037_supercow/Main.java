package school.faang.sprint_3.bjs2_37037_supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Boss sylvana = new Boss(1);
        Player nagibator = new Player("Nagibator");
        Player pwner = new Player("Pwner");
        Player ubivator = new Player("Ubivator_3000");
        Player healer = new Player("Lechilo");
        ExecutorService executor = Executors.newCachedThreadPool();

        for (Player player : Arrays.asList(nagibator, pwner, ubivator, healer)) {
            executor.execute(() -> player.startBattle(sylvana));
        }

        executor.shutdown();
    }
}
