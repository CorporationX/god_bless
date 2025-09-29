package bjs2_92591;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        QuestSystem questSystem = new QuestSystem();

        Player thrall = new Player("Тралл", 2, 250);
        Player sylvanas = new Player("Сильвана", 4, 450);

        Quest quest1 = new Quest("Победить Короля-лича", 10, 150);
        Quest quest2 = new Quest("Верните Меч Азерота", 8, 100);

        CompletableFuture<Player> thrallQuest = questSystem.startQuest(thrall, quest1);
        CompletableFuture<Player> sylvanasQuest = questSystem.startQuest(sylvanas, quest2);

        thrallQuest.thenAccept(player ->
                System.out.printf("%s завершил квест. Теперь у него %d опыта.%n",
                        player.getName(), player.getExperience()));

        sylvanasQuest.thenAccept(player ->
                System.out.printf("%s завершил квест. Теперь у него %d опыта.%n",
                        player.getName(), player.getExperience()));

        CompletableFuture.allOf(thrallQuest, sylvanasQuest).join();

        System.out.println("Все квесты выполнены!");
    }
}