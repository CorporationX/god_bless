package faang.school.godbless.multi_asyn.task2wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest)  {

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() / 2 * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            updateExp(player, quest);
            updateLvl(player);

            return player;
        });
    }

    private static void updateLvl(Player player) {
        int expForNewLvl = 500;
        int exp = player.getExperience();

        if (exp >= expForNewLvl) {
            int lvl = player.getLevel();
            player.setLevel(++lvl);
            player.setExperience(exp - expForNewLvl); // обновляем уровень, забираем опыт
            player.setNewLevel(true);
        }
    }

    private static void updateExp(Player player, Quest quest) {
        player.setExperience(player.getExperience() + quest.getReward() * quest.getDifficulty() / 10);
    }
}
