package faang.school.godbless.multithreading_async.the_triwizard_tournament;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание студентов, волшебных школ и заданий (пропущено, так как они предоставлены)


        School school1 = new School("school_1",
                List.of(new Student("st_1", 1993),
                        new Student("st_2", 1993),
                        new Student("st_3", 1993)));

        School school2 = new School("school_2",
                List.of(new Student("st_4", 1999),
                        new Student("st_5", 1993),
                        new Student("st_6", 1993)));


        // Запуск заданий
        System.out.println("Begin");
        CompletableFuture<School> school1Task = tournament.startTask(school1, new Task("Task1", 6, 100));
        System.out.println("Middle");
        CompletableFuture<School> school2Task = tournament.startTask(school2, new Task("Task1", 3, 200));
        System.out.println("End");
        // Обработка результатов заданий
        CompletableFuture.allOf(school1Task, school2Task)
                .thenRun(() -> {
                    if (school1.getTotalPoints() > school2.getTotalPoints()) {
                        System.out.println(ANSI_RED + "The winner of the magical tournament is " + school1.getName() + " with " + school1.getTotalPoints() + " points." + ANSI_RESET);
                    } else if (school2.getTotalPoints() > school1.getTotalPoints()) {
                        System.out.println(ANSI_RED + "The winner of the magical tournament is " + school2.getName() + " with " + school2.getTotalPoints() + " points." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "The magical tournament ended in a tie!" + ANSI_RESET);
                    }
                }).join();
    }
}
