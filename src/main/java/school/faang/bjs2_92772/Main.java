package school.faang.bjs2_92772;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.debug("Все участники приступают к квестам.");
        Player player1 = new Player("Вася", 6, 521);
        Player player2 = new Player("Петя", 2, 142);
        Player player3 = new Player("Даша", 1, 24);
        Player player4 = new Player("Маша", 8, 703);

        Quest quest1 = new Quest("Висеть на турнике", 9, 20);
        Quest quest2 = new Quest("Отжиматься с хлопками", 3, 20);
        Quest quest3 = new Quest("Готовить винегрет", 2, 20);
        Quest quest4 = new Quest("Вязать шапку", 12, 20);

        CompletableFuture<Player> completableFuturePlayer1 = QuestSystem.startQuest(player1, quest1);
        CompletableFuture<Player> completableFuturePlayer2 = QuestSystem.startQuest(player2, quest2);
        CompletableFuture<Player> completableFuturePlayer3 = QuestSystem.startQuest(player3, quest3);
        CompletableFuture<Player> completableFuturePlayer4 = QuestSystem.startQuest(player4, quest4);

        player1 = completableFuturePlayer1.get();
        log.debug("Игрок {} справился с квестом, теперь его опыт {}.", player1.getName(), player1.getExperience());
        player2 = completableFuturePlayer2.get();
        log.debug("Игрок {} справился с квестом, теперь его опыт {}.", player2.getName(), player2.getExperience());
        player3 = completableFuturePlayer3.get();
        log.debug("Игрок {} справился с квестом, теперь его опыт {}.", player3.getName(), player3.getExperience());
        player4 = completableFuturePlayer4.get();
        log.debug("Игрок {} справился с квестом, теперь его опыт {}.", player4.getName(), player4.getExperience());

        log.debug("Все участники закончили свои квесты.");
    }
}
