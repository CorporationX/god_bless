package faang.school.godbless;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<PlayerQuest> startQuest(PlayerQuest player, Quest quest) {
        PassQuest ref = (pl, q) -> {
            try {
                Thread.sleep(q.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            pl.setExperience(pl.getExperience() + q.getReward());
            return pl;
        };
        CompletableFuture<PlayerQuest> changedPlayer = CompletableFuture.supplyAsync(() -> ref.changePlayer(player, quest));
        return changedPlayer;
    }


    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

// Создание игроков
        PlayerQuest player1 = new PlayerQuest("Thrall", 10, 250);
        PlayerQuest player2 = new PlayerQuest("Sylvanas", 12, 450);

// Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

// Запуск заданий
        CompletableFuture<PlayerQuest> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<PlayerQuest> player2Quest = questSystem.startQuest(player2, quest2);
        player1Quest.join();
        player2Quest.join();
// Обработка результатов заданий
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
    }

}
