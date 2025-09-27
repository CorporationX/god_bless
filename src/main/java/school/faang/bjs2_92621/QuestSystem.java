package school.faang.bjs2_92621;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player p, Quest q) {
        return CompletableFuture.supplyAsync(() -> {
            synchronized (p) {
                try {
                    System.out.printf("%s started quest %s%n", p.getName(), q.getName());
                    Thread.sleep(q.getDifficulty() * 1000L);
                    p.setExperience(p.getExperience() + q.getReward());
                } catch (InterruptedException e) {
                    throw new RuntimeException("Something went wrong during the quest: " + e);
                }
                System.out.printf("%s completed quest %s and earned %d experience points%n",
                        p.getName(), q.getName(), q.getReward());
                return p;
            }
        });
    }
}