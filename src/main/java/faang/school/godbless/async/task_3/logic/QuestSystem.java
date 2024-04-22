package faang.school.godbless.async.task_3.logic;

import faang.school.godbless.async.task_3.model.Player;
import faang.school.godbless.async.task_3.model.Quest;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<Player> futurePlayer = CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " начал проходить " + quest.getName());
            int timeToPass = Math.abs(quest.getDifficulty() * 1000 - player.getLevel() * 200);
            try {
                Thread.sleep(timeToPass);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            player.addExperience(quest.getReward());
            return player;
            }, executor);
        executor.shutdown();
        return futurePlayer;
    }
}