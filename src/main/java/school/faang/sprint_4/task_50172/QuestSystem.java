package school.faang.sprint_4.task_50172;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty());
                player.addExperience(quest.reward());
                return player;
            } catch (InterruptedException e) {
                System.out.println("Поток " + Thread.currentThread().getName() + " прервал работу");
                return null;
            }
        });
    }
}
