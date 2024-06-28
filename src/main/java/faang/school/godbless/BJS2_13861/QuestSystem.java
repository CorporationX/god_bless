package faang.school.godbless.BJS2_13861;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

// Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

// Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

// Запуск заданий
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

// Обработка результатов заданий
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }


    private CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty());
                return quest.getReward();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).thenApply(result -> {
            player.setExperience(player.getExperience() + result);
            return player;
        });
    }
}
