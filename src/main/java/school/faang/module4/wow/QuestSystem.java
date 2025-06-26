package school.faang.module4.wow;

import school.faang.module4.wow.entity.Player;
import school.faang.module4.wow.entity.Quest;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> doQuest(player, quest));
    }


    private Player doQuest(Player player, Quest quest) {
        if (quest.getMinReqPlayerLvl() > player.getLevel()) {
            System.out.printf("Player \"%s\" can not start quest \"%s\" %d difficulty, minimal required level %d\n",
                    player.getName(), quest.getName(), quest.getDifficulty(), quest.getMinReqPlayerLvl());
            return player;
        }
        System.out.printf("Player \"%s\" start quest \"%s\" %d difficulty\n",
                player.getName(), quest.getName(), quest.getDifficulty());
        try {
            Thread.sleep(quest.getQuestTimeInMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.printf("Player \"%s\" finished quest \"%s\" %d difficulty\n",
                player.getName(), quest.getName(), quest.getDifficulty());
        player.addExperience(quest.getReward());
        return player;
    }


    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 1, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 2, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        Consumer<Player> printer = (player) -> {
            System.out.printf("%s has completed the quest and now has %d experience points.\n",
                    player.getName(), player.getExperience());
        };

        player1Quest.thenAccept(printer);
        player2Quest.thenAccept(printer);
        player1Quest.join();
        player2Quest.join();
    }
}
