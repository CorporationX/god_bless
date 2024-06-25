package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_6_royal_harbor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static final String MSG_FINISH = "Турнир окончен.";
    public static final String MSG_ERROR = "Работа программы прервана.";
    public static final int TIME_OUT = 20;

    public static void main(String[] args) {
        int numberCompetitors = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(numberCompetitors);

        Knight shonKnight = new Knight("Shon");
        shonKnight.addTrial("Выпить 0,5 горькой.");
        shonKnight.addTrial("Поймать единорога.");

        Knight beanKnight = new Knight("Bean");
        beanKnight.addTrial("Селфи с драконом.");
        beanKnight.addTrial("Провести ночь за стеной.");

        Knight johnKnight = new Knight("John Snow");
        johnKnight.addTrial("Разбить сердце одичалой");
        johnKnight.addTrial("Пронзить сердце матери драконов");
        johnKnight.addTrial("Ничего не понять");

        Tournament tournament = new Tournament();
        tournament.addKnight(beanKnight);
        tournament.addKnight(shonKnight);
        tournament.addKnight(johnKnight);

        for (Knight knight : tournament.knights()) {
            executorService.submit(knight);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(MSG_ERROR);
        }

        System.out.println(MSG_FINISH);
    }
}
