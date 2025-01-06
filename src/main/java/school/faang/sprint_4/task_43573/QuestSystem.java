package school.faang.sprint_4.task_43573;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final long BASE_QUEST_TIME = 1_000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " начинает квест " + quest.name());
            try {
                Thread.sleep(BASE_QUEST_TIME * quest.difficulty());
            } catch (InterruptedException e) {
                System.out.println("Игрок прервал выполнение квеста!");
            }
            player.increaseExperience(quest.reward());
            return player;
        });
    }
}
