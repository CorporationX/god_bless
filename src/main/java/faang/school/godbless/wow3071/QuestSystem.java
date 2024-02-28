package faang.school.godbless.wow3071;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException {
        QuestSystem questSystem = new QuestSystem();
        Player demonSlayer = new Player("DeMoN_SlAyEr", 10, 250);
        Player boobBeep = new Player("Boob-Beep", 12, 450);
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> demonSlayerQuest = questSystem.startQuest(demonSlayer, quest1);
        CompletableFuture<Player> boobBeepQuest = questSystem.startQuest(boobBeep, quest2);
        demonSlayerQuest.thenAccept(player -> System.out.printf("Current XP: %d%n", player.getExperience()));
        boobBeepQuest.thenAccept(player -> System.out.printf("Current XP: %d%n", player.getExperience()));
        EXECUTOR.shutdown();
    }

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("%s is trying to %s. Reward: %dXP%n", player.getName(), quest.getName(), quest.getReward());
            threadSleep(quest.getDifficulty() * 1000L);
            player.setExperience(player.getExperience() + quest.getReward());
            System.out.printf("%s completed the quest!%n", player.getName());
            return player;
        }, EXECUTOR);
    }

    private void threadSleep(long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
