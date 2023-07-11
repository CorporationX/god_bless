package faang.school.godbless.sprint_3.multithreading_future.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        System.out.printf("%s взяли квест: %s. Уровень сложности квеста: %d, и награда за его выполнение %d experience%n", player.getName(), quest.getName(), quest.getDifficulty(), quest.getReward());
        return CompletableFuture.supplyAsync(() -> {
            int wait = quest.getDifficulty() * 1000;
            try {
                Thread.sleep(wait);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.printf("%s выполнил %s, Ваша награда %d experience%n", quest.getName(), player.getName(), quest.getReward());
            int experience = player.getExperience();
            player.setExperience(experience + quest.getReward());
            while (player.getExperience() >= 1000) {
                int currentLvl = player.getLevel();
                int currentExperience = player.getExperience();
                player.setLevel(currentLvl + 1);
                player.setExperience(currentExperience - 1000);
            }
            return player;
        });
    }
}