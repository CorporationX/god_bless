package school.faang.sprint_4.bjs2_38338_starWarsArena;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        List<Robot> robots = List.of(
                new Robot("R2-D2", 5, 7),
                new Robot("C-3PO", 4, 8),
                new Robot("BB-8", 6, 6),
                new Robot("Wall-E", 3, 5),
                new Robot("Optimus Prime", 9, 9),
                new Robot("Bumblebee", 7, 8),
                new Robot("Terminator T-800", 10, 10),
                new Robot("Data", 8, 9),
                new Robot("HAL 9000", 9, 8),
                new Robot("Astro Boy", 6, 7)
        );

        CompletableFuture.allOf(battle.fightEveryone(robots).toArray(new CompletableFuture[0])).join();
        battle.shutdown();
        battle.printResults(robots);
    }
}
