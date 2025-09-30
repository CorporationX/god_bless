package school.faang.bjs2_92568;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Balmond", 25, 654);
        Player player2 = new Player("Voltramon", 33, 825);
        Player player3 = new Player("Tarkus", 128, 2244);

        Quest quest1 = new Quest("Убийство принца Нигерии", 3, 345);
        Quest quest2 = new Quest("Доказать царю, что Земля плоская", 10, 1000);
        Quest quest3 = new Quest("Убить Джонатана Джостара и Уильяма Антонио Цеппели", 4, 350);

        CompletableFuture<Player> playerQuest1 = QuestSystem.startQuest(player1, quest1);
        CompletableFuture<Player> playerQuest2 = QuestSystem.startQuest(player2, quest2);
        CompletableFuture<Player> playerQuest3 = QuestSystem.startQuest(player3, quest3);

        playerQuest1.thenAccept(player -> System.out.printf("%s окончил квест и теперь имеет %d очков и %d уровень\n",
                player.getName(), player.getExperience(), player.getLevel()));
        playerQuest2.thenAccept(player -> System.out.printf("%s окончил квест и теперь имеет %d очков и %d уровень\n",
                player.getName(), player.getExperience(), player.getLevel()));
        playerQuest3.thenAccept(player -> System.out.printf("%s окончил квест и теперь имеет %d очков и %d уровень\n",
                player.getName(), player.getExperience(), player.getLevel()));
    }
}