package task_BJS2_62246;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> futureQuest = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("Игрок %s проходит квест %s\n", player.getName(), quest.getName());
            return null; //player.setExperience(player.getExperience() + quest.getReward()) - вызывает ошибку!
        });

        futureQuest.thenAccept(playerAfterQuest -> {
            System.out.printf("Игрок %s прошёл квест %s и теперь его опыт равен %d\n",
                    player.getName(), quest.getName(), player.getExperience());
        });

        return futureQuest;

    }

}
