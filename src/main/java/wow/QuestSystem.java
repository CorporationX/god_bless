package wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private final int sec = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Игрок: " + player.getName() + ", начинает квест: " + quest.getName());
            System.out.println("Сложность: " + quest.getDifficulty() + "");

            try {
                Thread.sleep(quest.getDifficulty() * sec);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException("Квест прерван!");
            }

            player.addExperience(quest.getReward());
            System.out.println(player.getName() + " выполнил квест и получил " + quest.getReward() + " очков опыта ");

            return player;
        });

    }
}
