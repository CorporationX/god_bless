package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public record QuestSystem() {
    public void startQuest(Player player, Quest quest) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.difficulty() * 1000L);
                player.setExperience(player.getExperience() + quest.reward());
                Player.playerTask = quest.name();
                executor.shutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Поток был прерван!");
            }
            return player;
        }, executor).thenAccept(plr -> System.out.println(plr.getName()
                + " выполнил задачу " + Player.getPlayerTask() + " и имеет "
                + plr.getExperience()
                + " опыта."));
    }
}
