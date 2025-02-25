package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player firstPayer = new Player("Boby", 1, 0);
        Player secondPlayer = new Player("Ihor", 2, 0);

        Quest firstQuest = new Quest("Black Wood", Quest.Difficulty.EASY, 500);
        Quest secondQuest = new Quest("Dragon Egg", Quest.Difficulty.HARD, 2750);

        CompletableFuture<Player> firstPlayerQuest = questSystem.startQuest(firstPayer, secondQuest);
        CompletableFuture<Player> secondPlayerQuest = questSystem.startQuest(secondPlayer, firstQuest);

        firstPlayerQuest.join();
        secondPlayerQuest.join();

    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                player.setExperience(player.getExperience() + quest.getReward());
                log.info("Квест: " + quest.getName() +
                        " успешно завершен. Игрок " + player.getName()
                        + " получает " + quest.getReward() + " опыта. Опыт игрока: " + player.getExperience());
            } catch (InterruptedException e) {
                log.error("Ошибка при выполенении квеста ", e);
            }
            return player;
        });
    }

}