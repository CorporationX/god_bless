package faang.school.godbless.WOW;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        List<Player> players = createPlayers();
        List<Quest> quests = createQuests();
        for (Player player : players) {
            for (Quest quest : quests) {
                CompletableFuture<Player> result = questSystem.startQuest(player, quest);
                result.thenAccept(i -> System.out.println(i.getName() + " получил " + quest.getReward() + " опыта"));
            }
        }
        questSystem.getExecutorService().shutdown();
    }

    private static List<Player> createPlayers() {
        return List.of(
                new Player("Thrall", 10, 250),
                new Player("Sylvanas", 12, 450));
    }

    private static List<Quest> createQuests() {
        return List.of(
                new Quest("Defeat the Lich King", 10, 150),
                new Quest("Retrieve the Sword of Azeroth", 8, 100));
    }
}
