package school.faang.sprint_4.bjs2_38338_starWarsArena;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();
        String[][] robotData = {
                {"C-3PO", "4", "8"},
                {"BB-8", "6", "6"},
                {"Wall-E", "3", "5"},
                {"Optimus Prime", "9", "9"},
                {"Bumblebee", "7", "8"},
                {"Terminator T-800", "10", "10"},
                {"Data", "8", "9"},
                {"HAL 9000", "9", "8"},
                {"Astro Boy", "6", "7"},
                {"R2-D2", "5", "7"}
        };
        List<Robot> robots = new ArrayList<>();
        for (String[] data : robotData) {
            robots.add(new Robot(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
        }

        CompletableFuture.allOf(battle.fightEveryone(robots).toArray(new CompletableFuture[0])).join();
        battle.shutdown();
        battle.printResults(robots);
    }
}
