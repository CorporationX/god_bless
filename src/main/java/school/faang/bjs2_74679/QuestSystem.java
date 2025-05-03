package school.faang.bjs2_74679;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("Игрок %s начал выполнение квеста %s%n", player.getName(), quest.name());
                Thread.sleep(quest.difficulty() * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.printf("Игрок %s завершил квест %s и получает %d опыта%n",
                    player.getName(), quest.name(), quest.reward());
            player.setExperience(player.getExperience() + quest.reward());
            return player;
        });
    }
}
