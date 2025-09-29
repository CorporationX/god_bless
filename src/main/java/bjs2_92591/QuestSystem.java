package bjs2_92591;

import java.util.concurrent.CompletableFuture;

class QuestSystem {
    private static final long MILLIS_IN_SECOND = 1000L;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("%s начинает квест \"%s\" (сложность %d)...%n",
                        player.getName(), quest.getName(), quest.getDifficulty());

                Thread.sleep(quest.getDifficulty() * MILLIS_IN_SECOND);

                synchronized (player) {
                    player.addExperience(quest.getReward());
                }

                System.out.printf("%s завершил квест \"%s\" и получил %d опыта%n",
                        player.getName(), quest.getName(), quest.getReward());

                return player;

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Квест был прерван!", e);
            }
        });
    }
}