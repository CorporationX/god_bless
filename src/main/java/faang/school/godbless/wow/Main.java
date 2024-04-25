package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player thrall = new Player("Thrall", 10, 250);
        Player sylvanas = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> thrallQuest = questSystem.startQuest(thrall, quest1);
        CompletableFuture<Player> sylvanasQuest = questSystem.startQuest(sylvanas, quest2);

        thrallQuest.thenAccept(player -> System.out.println(player.getName()
                + " завершил квест и сейчас его опыт: " + player.getExperience() + " xp"));
        sylvanasQuest.thenAccept(player -> System.out.println(player.getName()
                + " завершила квест и сейчас её опыт: " + player.getExperience() + " xp"));
        thrallQuest.join();
        sylvanasQuest.join();
    }
}
