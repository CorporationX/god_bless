package faang.school.godbless.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    public static void main(String[] args) {
        Player invoker = new Player("Invoker", 11, 300);
        Player axe = new Player("Axe", 4, 75);
        Player jakiro = new Player("Jakiro", 6, 130);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        Quest quest3 = new Quest("Take the altar of freedom", 13, 180);

        CompletableFuture<Player> invokerQuest1 = QuestSystem.startQuest(invoker, quest1);
        CompletableFuture<Player> axeQuest2 = QuestSystem.startQuest(axe, quest2);
        CompletableFuture<Player> jakirQuest3 = QuestSystem.startQuest(jakiro, quest3);

        invokerQuest1.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        axeQuest2.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        jakirQuest3.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
    }


    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(); //У меня без executorService
        CompletableFuture<Player> goQuest = CompletableFuture.supplyAsync(() -> {
            System.out.println("Начинается испытание");  //программа завершаетс на данном методе, выводит только эту строку  и все!
            try {                                    //  Поэтому создал синглЭкзекутор, либо надо было создавать new Thread
                System.out.println("Время для прохождения задания: " + quest.getDifficulty() + " секунд");
                Thread.sleep(quest.getDifficulty() * 1_000L);
                System.out.println("В работе: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Соединение с сервером прерванно");
            }
            return player;
        }, executorService).thenApply((result) -> {              //передаем результат метода supplyAsync
            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });
        executorService.shutdown();
        return goQuest;
    }
}


@Getter
@Setter
@AllArgsConstructor
class Player {
    private String name;
    private int level;
    private int experience;
}


@Getter
@AllArgsConstructor
class Quest {
    private String name;
    private int difficulty;
    private int reward;
}