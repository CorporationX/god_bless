package wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Bill", 3, 150);
        Player player2 = new Player("Max", 5, 200);
        Player player3 = new Player("Torr", 7, 250);

        Quest quest1 = new Quest("Kindom", 5, 100);
        Quest quest2 = new Quest("Swamp", 7, 200);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest1);
        CompletableFuture<Player> player3Quest = questSystem.startQuest(player3, quest1);
        CompletableFuture<Player> player1Quest2 = questSystem.startQuest(player1, quest2);
        CompletableFuture<Player> player2Quest2 = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> player3Quest2 = questSystem.startQuest(player3, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points"));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points"));
        player3Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points"));
        player1Quest2.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points"));
        player2Quest2.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points"));
        player3Quest2.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points"));

        CompletableFuture.allOf(player1Quest, player2Quest, player3Quest, player1Quest2, player2Quest2, player3Quest2).join();
        ExecutorService questExecutor =  questSystem.getQuestExecutor();
        questExecutor.shutdown();
        try {
            if(!questExecutor.awaitTermination(20, TimeUnit.SECONDS)){
                questExecutor.shutdownNow();
            }
        }catch (InterruptedException e){
            questExecutor.shutdownNow();
            e.printStackTrace();
        }
    }
}
