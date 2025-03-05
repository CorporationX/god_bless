package school.faang.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Ванька", 100, 1000);
        Quest quest1 = new Quest("Помыть посуду", 10, 1000);
        CompletableFuture<Player> playerQuest1 = questSystem.startQuest(player1, quest1);

        Player player2 = new Player("Димка", 2, 200);
        Quest quest2 = new Quest("Побрить собаку", 2, 100);
        CompletableFuture<Player> playerQuest2 = questSystem.startQuest(player2, quest2);

        Player player3 = new Player("Ринат", 999, 9990);
        Quest quest3 = new Quest("Сделать ревью", Integer.MAX_VALUE, 1);
        CompletableFuture<Player> playerQuest3 = questSystem.startQuest(player3, quest3);

        playerQuest1.thenAccept(Player::getInfo).join();
        playerQuest2.thenAccept(Player::getInfo).join();
        playerQuest3.thenAccept(Player::getInfo).join();
    }
}
