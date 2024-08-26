package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        System.out.println("Зашли в метод > startQuest - " + Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Над задачей работает поток - " + Thread.currentThread().getName());

                Thread.sleep(quest.getDifficulty() * 1000L);
                player.setExperience(player.getExperience() + quest.getDifficulty());

                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });
    }
}
