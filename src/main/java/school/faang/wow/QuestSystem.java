package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private final int questTime = 1000;

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
                Thread.sleep(questTime);
                synchronized (player) {
                    player.setExperience(player.getExperience() + quest.getReward());
                }
                log.info(String.format("Квест: %s успешно завершен. Игрок %s получает %d опыта. Опыт игрока: %d.",
                        quest.getName(), player.getName(), quest.getReward(), player.getExperience()));
            } catch (InterruptedException e) {
                log.error(String.format(
                        "Ошибка при выполенении квеста %s у игрока %s ", quest.getName(), player.getName(), e));
                Thread.currentThread().interrupt();
            }
            return player;
        });
    }

}