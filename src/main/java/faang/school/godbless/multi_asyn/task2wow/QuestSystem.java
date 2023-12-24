package faang.school.godbless.multi_asyn.task2wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
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
