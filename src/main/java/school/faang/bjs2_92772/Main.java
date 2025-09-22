package school.faang.bjs2_92772;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuestSystem.startQuest(
                new Player("Вася", 6, 521),
                new Quest("Висеть на турнике", 9, 20)).get();
        QuestSystem.startQuest(
                new Player("Петя", 2, 142),
                new Quest("Отжиматься с хлопками", 3, 20)).get();
        QuestSystem.startQuest(
                new Player("Даша", 1, 24),
                new Quest("Готовить винегрет", 2, 20)).get();
        QuestSystem.startQuest(
                new Player("Маша", 8, 703),
                new Quest("Вязать шапку", 12, 20)).get();
        QuestSystem.startQuest(
                new Player("Глаша", 4, 389),
                new Quest("Готовить франшконте", 6, 20)).get();
    }
}
