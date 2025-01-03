package school.faang.sprint4.bjs250145;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player firstPlayer = new Player("Aragorn", 1, 100);
        Player secondPlayer = new Player("Droe", 3, 3500);

        Quest quest1 = new Quest("Find empty", 5, 500);
        Quest quest2 = new Quest("Touch tree", 2, 200);

        CompletableFuture<Player> firstPlayerQuest = questSystem.startQuest(firstPlayer, quest1);
        CompletableFuture<Player> secondPlayerQuest = questSystem.startQuest(secondPlayer, quest2);

        firstPlayerQuest.thenAccept(questSystem::printTextInfo);
        secondPlayerQuest.thenAccept(questSystem::printTextInfo);

        CompletableFuture.allOf(firstPlayerQuest, secondPlayerQuest).join();
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error("Ошибка в потоке, выполняющем задержку: {}", e.getMessage());
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }

    public void printTextInfo(Player player) {
        System.out.println(player.getName() + " has completed the quest. Experience points: " + player.getExperience());
    }
}