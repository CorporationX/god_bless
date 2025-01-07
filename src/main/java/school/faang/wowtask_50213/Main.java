package school.faang.wowtask_50213;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Player paladin = new Player("Artas", 1, 0);
        Player archmage = new Player("Orin", 15, 1560);

        Quest protectTheVillage = new Quest("Protect the village", 4, 150);
        Quest killBanditLeader = new Quest("Kill the bandit leader", 7, 600);

        QuestSystem questSys = new QuestSystem();
        CompletableFuture<Player> missionOne = questSys.startQuest(paladin, protectTheVillage);
        CompletableFuture<Player> missionTwo = questSys.startQuest(archmage, killBanditLeader);
    }
}
