package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class QuestSystem {
    private final ExecutorService executorService;

    public QuestSystem(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return startAttach(player, quest);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
    }

    private Player startAttach(Player player, Quest quest) throws InterruptedException {
        switch (quest.getDifficulty()) {
            case HIGH:
                Thread.sleep(10_000);
                player.setExperience(player.getExperience() + 10);
                System.out.println(player.getName() + " опыт " + player.getExperience());
            case LOW:
                Thread.sleep(5_000);
                player.setExperience(player.getExperience() + 5);
                System.out.println(player.getName() + " опыт " + player.getExperience());
            case MIN:
                Thread.sleep(1_000);
                player.setExperience(player.getExperience() + 1);
                System.out.println(player.getName() + " опыт " + player.getExperience());
        }
        return player;
    }
}