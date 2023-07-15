package faang.school.godbless.Multithreading.Asynchronism.task03_WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> result = CompletableFuture.supplyAsync(() -> fight(player, quest));
        return result;
    }
    public Player fight(Player player, Quest quest){
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " Is interrupt");
            Thread.currentThread().interrupt();
        }
        player.setExperience(player.getExperience() + quest.getReward());
        return player;
    }
}
