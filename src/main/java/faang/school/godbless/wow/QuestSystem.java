package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Уровень игрока " + player.getName() + " = " + player.getLevel());
            System.out.println("Опыт игрока " + player.getName() + " = " + player.getExperience());
            System.out.println(player.getName() + " выполняет " + quest.getName());
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            System.out.println(player.getName() + " закончил выполнение " + quest.getName());
            if (player.getExperience() == 100) {
                player.setLevel(player.getLevel() + 1);
            }
            return player;
        });
    }
}
