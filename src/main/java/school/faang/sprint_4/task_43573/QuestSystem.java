package school.faang.sprint_4.task_43573;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final long THREAD_SLEEP = 1_000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " начинает квест " + quest.name());
            try {
                Thread.sleep(THREAD_SLEEP * quest.difficulty());
            } catch (InterruptedException e) {
                System.out.println("Игрок прервал выполнение квеста!");
            }
            player.setExperience(player.getExperience() + quest.reward());
            return player;
        });
    }
}
