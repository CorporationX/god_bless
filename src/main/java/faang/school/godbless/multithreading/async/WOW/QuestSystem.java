package faang.school.godbless.multithreading.async.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class QuestSystem {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        // Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        // Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 4, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        // Запуск заданий
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        // Обработка результатов заданий
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " +
                player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(
                player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws ExecutionException, InterruptedException {

        CompletableFuture<Player> playerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1_000L * quest.getDifficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        playerCompletableFuture.get();
        return playerCompletableFuture;
    }
}
