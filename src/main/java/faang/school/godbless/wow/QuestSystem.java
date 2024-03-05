package faang.school.godbless.wow;


import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) throws InterruptedException {
        System.out.println("Player " + player.getName() + " started the task " + quest.getName());

        switch (quest.getDifficulty()) {
            case "easy":
                Thread.sleep(1000/player.getLevel());
                break;
            case "medium":
                Thread.sleep(5000/player.getLevel());
                break;
            case "hard":
                Thread.sleep(7000/player.getLevel());
                break;
            case "very hard":
                Thread.sleep(10000/player.getLevel());
                break;
        }
        return CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
    }
}

