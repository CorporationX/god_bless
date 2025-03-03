package school.faang.task_62236;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int THRALL_INITIAL_LEVEL = 10;
    private static final int THRALL_INITIAL_EXPERIENCE = 250;
    private static final int SYLVANAS_INITIAL_LEVEL = 12;
    private static final int SYLVANAS_INITIAL_EXPERIENCE = 450;
    private static final int LICH_KING_DIFFICULTY = 10;
    private static final int LICH_KING_REWARD = 150;
    private static final int SWORD_OF_AZEROTH_DIFFICULTY = 8;
    private static final int SWORD_OF_AZEROTH_REWARD = 100;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", THRALL_INITIAL_LEVEL, THRALL_INITIAL_EXPERIENCE);
        Player player2 = new Player("Sylvanas", SYLVANAS_INITIAL_LEVEL, SYLVANAS_INITIAL_EXPERIENCE);

        Quest quest1 = new Quest("Defeat the Lich King", LICH_KING_DIFFICULTY, LICH_KING_REWARD);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", SWORD_OF_AZEROTH_DIFFICULTY, SWORD_OF_AZEROTH_REWARD);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        questSystem.processQuestResult(player1Quest);
        questSystem.processQuestResult(player2Quest);

        CompletableFuture.allOf(player1Quest, player2Quest).join();

        questSystem.shutdown();
    }

}
