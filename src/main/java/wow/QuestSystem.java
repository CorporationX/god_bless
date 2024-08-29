package wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private final static int QUEST_DELAY = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("%s начал своё путешествие %s\n", player.getName(), quest.getName());
            try {
                Thread.sleep( QUEST_DELAY * quest.getDifficulty());
                player.completeQuest(quest);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.printf("%s завершил своё путешествие %s\n", player.getName(), quest.getName());

            return player;
        });
    }
}
