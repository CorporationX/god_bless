package school.faang.bjs274707;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        List<CompletableFuture<Object>> futures = new ArrayList<>();

        IntStream.rangeClosed(1, 10).forEach(i -> {
            int level = (int) (Math.random() * 12) + 1;
            int experience = (int) (Math.random() * 500);
            int reward = (int) (Math.random() * 150);
            Player player = new Player("Player " + i, level, experience);
            Quest quest = new Quest("Quest  " + i, level, reward);

            CompletableFuture<Object> future = questSystem
                    .startQuest(player, quest)
                    .thenAccept(p -> System.out.printf(
                            "%s has completed %s and now has %d experience points%n",
                            p.getName(), quest.name(), p.getExperience()))
                    .thenApply(p -> p);
            futures.add(future);
        });

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .join();
        System.out.println("All completed");
    }
}
