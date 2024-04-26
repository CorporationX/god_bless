package faang.school.godbless.async.triwizardTournament;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {

    private static final School HOGWARTS;
    private static final School BEAUXBATONS;
    private static final List<Task> TASKS;

    static {
        // Создание студентов, волшебных школ и заданий
        List<Student> hogwartsStudents = new ArrayList<>();
        hogwartsStudents.add(new Student("Garry", 4, 0));
        hogwartsStudents.add(new Student("Ron", 4, 0));
        hogwartsStudents.add(new Student("Nevil", 4, 0));

        HOGWARTS = new School("Hogwarts", hogwartsStudents);


        List<Student> beauxbatonsStudents = new ArrayList<>();
        beauxbatonsStudents.add(new Student("Fleur", 5, 0));
        beauxbatonsStudents.add(new Student("Croiss", 5, 0));
        beauxbatonsStudents.add(new Student("Bague", 5, 0));

        BEAUXBATONS = new School("Hogwarts", beauxbatonsStudents);

        Task task1 = new Task("Fight the dragon", 20, 200);
        Task task2 = new Task("Get your friend from the bottom of the lake" , 10, 100);
        TASKS = List.of(task1, task2);
    }

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(HOGWARTS, TASKS.get(0));
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(BEAUXBATONS, TASKS.get(1));

        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (HOGWARTS.getTotalPoints() > BEAUXBATONS.getTotalPoints()) {
                log.info("The winner of the magical tournament is " + HOGWARTS.name() + " with " + HOGWARTS.getTotalPoints() + " points.");
            } else if (BEAUXBATONS.getTotalPoints() > HOGWARTS.getTotalPoints()) {
                log.info("The winner of the magical tournament is " + BEAUXBATONS.name() + " with " + BEAUXBATONS.getTotalPoints() + " points.");
            } else {
                log.info("The magical tournament ended in a tie!");
            }
        }).join();
    }
}
