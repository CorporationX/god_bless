package school.faang.task_50006;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Гарри Поттер", 12, 150);
        Player player2 = new Player("Рон Уизли", 11, 100);

        Quest quest1 = new Quest("Уничтожить троля", 12, 100);
        Quest quest2 = new Quest("Выиграть в квитич", 10, 90);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> QuestSystem.LOGGER.debug("{} выполнил квест и теперь имеет награду - {}",
                player.getName(), player.getExperience()));
        player2Quest.thenAccept(player -> QuestSystem.LOGGER.debug("{} выполнил квест и теперь имеет награду - {}",
                player.getName(), player.getExperience()));
    }
}
