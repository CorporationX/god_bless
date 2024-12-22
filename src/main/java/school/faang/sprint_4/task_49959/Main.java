package school.faang.sprint_4.task_49959;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        List<Player> players = getPlayers();
        List<Quest> quests = getQuests();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Quest quest = quests.get(i);

            CompletableFuture<Player> playerQuest = questSystem.startQuest(player, quest);

            playerQuest.thenAccept(updatedPlayer -> {
                System.out.println(updatedPlayer.getName() + " завершил квест и сейчас имеет "
                        + updatedPlayer.getExperience() + " очков опыта.");
            });
            playerQuest.join();
        }
    }

    private static List<Player> getPlayers() {
        return List.of(
                new Player("Thrall", 10, 250),
                new Player("Sylvanas", 12, 450),
                new Player("Jaina", 15, 600),
                new Player("Guldan", 14, 500),
                new Player("Anduin", 13, 550),
                new Player("Voljin", 11, 300)
        );
    }

    private static List<Quest> getQuests() {
        return List.of(
                new Quest("Defeat the Lich King", Difficulty.HARD, 150),
                new Quest("Retrieve the Sword of Azeroth", Difficulty.MEDIUM, 100),
                new Quest("Find the Lost Artifact", Difficulty.EASY, 50),
                new Quest("Rescue the Princess", Difficulty.MEDIUM, 120),
                new Quest("Slay the Dragon", Difficulty.HARD, 200),
                new Quest("Explore the Dark Forest", Difficulty.MEDIUM, 80)
        );
    }
}
