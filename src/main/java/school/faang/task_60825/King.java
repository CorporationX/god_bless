package school.faang.task_60825;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        List<String> knightsNames = List.of("Sir Lancelot", "Sir Galahad");
        List<String> trialsNames = List.of(
                "The Enchanted Forest",
                "The Dragon's Lair",
                "The Goblin Caves",
                "The Whispering Mountains",
                "The Sorcerer's Tower",
                "The Crystal Maze",
                "The River of Fire"
        );

        ExecutorService executorService = Executors.newFixedThreadPool(knightsNames.size());
        for (String knightName : knightsNames) {
            Knight knight = new Knight(knightName);
            for (String trialName : trialsNames) {
                Trial trial = new Trial(knightName, trialName);
                knight.addTrial(trial);
            }
            executorService.execute(knight::startTrials);
        }
        executorService.shutdown();
    }
}
