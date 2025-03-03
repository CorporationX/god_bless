package WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() ->  {
            try {
                System.out.println("Игрок: " + player.getName() + " начал выполнение квеста: " + quest.getName());
                Thread.sleep(quest.getDifficulty() * 100L);
                if (player.getLevel() >= quest.getDifficulty()) {
                    player.addExperience(quest.getReward());
                    System.out.println("Игрок: " + player.getName() + " выполнил задание " + quest.getName());
                } else {
                    System.out.println("Игрок " + player.getName() + " не может выполнить задание '"
                            + quest.getName() + "'. Недостаточный уровень.");
                }
            } catch (InterruptedException e) {
                System.out.println("Выполнение задания '" + quest.getName() + "' было прервано.");
                Thread.currentThread().interrupt();
            }
            return player;
        });
    }
}
