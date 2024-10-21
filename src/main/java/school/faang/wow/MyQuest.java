package school.faang.wow;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MyQuest {
    public static void main(String[] args) {
        QuestSystem system = new QuestSystem();
        List<CompletableFuture<Player>> allCompletableFuture = List.of(
                system.startQuest(new Player("Maks", 1), new Quest("Warships", 5, 100)),
                system.startQuest(new Player("Rusik", 2), new Quest("World of Tanks", 3, 150)));
        allCompletableFuture.stream()
                .map(CompletableFuture::join)
                .forEach(Player::showPlayer);
    }
}
