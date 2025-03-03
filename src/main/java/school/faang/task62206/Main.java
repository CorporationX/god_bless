package school.faang.task62206;

import school.faang.task62206.service.Player;
import school.faang.task62206.service.Quest;
import school.faang.task62206.service.QuestSystem;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Варвар", 10, 230);
        Player player2 = new Player("Волшебник", 12, 370);

        Quest quest1 = new Quest("Забрать меч у дракона победив его", 7, 120);
        Quest quest2 = new Quest("Отдать меч дракона кузнецу, получить новый супер меч", 3, 80);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName()+" смог выполнить задание и получил "+player.getExperience()+" очков опыта."));
        player2Quest.thenAccept(player -> System.out.println(player.getName()+" смог выполнить задание и получил "+player.getExperience()+" очков опыта."));

        CompletableFuture.allOf(player1Quest, player2Quest).join();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Квесты завершены.");
    }
}
