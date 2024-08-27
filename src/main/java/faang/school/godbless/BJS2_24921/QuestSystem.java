package faang.school.godbless.BJS2_24921;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> res = CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " начал выполнять задание");
            try {
                Thread.sleep(1000 * quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.addExperience(quest.getReward());
            return player;
        });
        return res;
    }

}
