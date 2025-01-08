package derschrank.sprint04.task02.bjstwo_50097;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        List<Player> players = List.of(player1, player2);

        List<Quest> quests = getQuests();
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (Quest quest : quests) {
            for (Player player : players) {
                CompletableFuture<Player> future = questSystem.startQuest(player, quest);
                futures.add(future.thenAccept(p -> System.out.println(p.getName()
                        + " has completed the quest and now has "
                        + p.getExperience() + " experience points."))
                );
            }
        }

        futures.forEach(CompletableFuture::join);
    }

    private static List<Quest> getQuests() {
        Object[] arrayOfQuestsParameters = getArrayOfQuestsParameters();
        String[] names = (String[]) arrayOfQuestsParameters[0];
        int[] difficulty = (int[]) arrayOfQuestsParameters[1];
        int[] reward = (int[]) arrayOfQuestsParameters[2];

        List<Quest> quests = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            quests.add(new Quest(
                    names[i],
                    difficulty[i % difficulty.length],
                    reward[i % reward.length]
            ));
        }
        return quests;
    }

    private static Object[] getArrayOfQuestsParameters() {
        String[] names = new String[]{
                "Defeat the Lich King",
                "Defeat the King Lich",
                "Defeat the Lich Lich King",
                "Defeat the King King Lich",
                "Defeat the Lich * King",
                "Retrieve the Sword of Azeroth",
                "Retrieve the Sword of Lich",
                "Retrieve the Sword of King",
                "Retrieve the Sword of Defeat",
                "Retrieve the Sword of King Azeroth"};
        int[] diffuculty = {10, 11, 12, 13, 14, 8, 7, 6, 5, 9};
        int[] reward = {150, 150, 150, 150, 250, 100, 100, 100, 100, 200};

        return new Object[]{names, diffuculty, reward};
    }
}
