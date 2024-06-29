package faang.school.godbless;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest (Player player, Quest quest) {
        PassQuest ref = (pl, q) -> {
            try {
                Thread.sleep(q.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            pl.setExperience(pl.getExperience() + q.getReward());
            return pl;
        };
        CompletableFuture<Player> changedPlayer = CompletableFuture.supplyAsync(()-> ref.changePlayer(player,quest));
        return changedPlayer;
    }


    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

// Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

// Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

// Запуск заданий
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        //Без строчки ниже у меня не работает, не ждёт основной поток выполнения тех двух потоков.
        //Подскажите, почему, пожалуйста?
        while(!player1Quest.isDone()&&!player2Quest.isDone()) {
        }
// Обработка результатов заданий
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}
