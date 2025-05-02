package school.faang.bjs274601;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int WAITING_TIME = 10_000;
    private static final  int THREAD_COUNT = 3;

    public static void main(String[] args) {
        Player illidan = new Player("Illidan");
        Player sylvanas = new Player("Sylvanas");
        Player arthas = new Player("Arthas");

        Quest easyQuest = new Quest("Herbalist", Difficult.EASY, Reward.SMALL);
        Quest mediumQuest = new Quest("Goblin hunter", Difficult.MEDIUM, Reward.MEDIUM);
        Quest hardQuest = new Quest("Blood of a Titan", Difficult.HARD, Reward.BIG);

        QuestSystem system = new QuestSystem();
        CompletableFuture<Player> arthasQuestResult = system.startQuest(arthas, easyQuest);
        CompletableFuture<Player> sylvanasQuestResult = system.startQuest(sylvanas, mediumQuest);
        CompletableFuture<Player> illidanQuestResult = system.startQuest(illidan, hardQuest);

        illidanQuestResult.thenAccept(Main::logQuestInfo);
        sylvanasQuestResult.thenAccept(Main::logQuestInfo);
        arthasQuestResult.thenAccept(Main::logQuestInfo);
        try {
            Thread.sleep(WAITING_TIME);
        } catch (InterruptedException e) {
            log.error("Thread interrupted: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public static void logQuestInfo(Player player) {
        log.info("{} has completed quest, current experience: {}", player.getName(), player.getExperience());
    }
}
