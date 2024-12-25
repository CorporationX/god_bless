package school.faang.task_50861;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student("Гарри", 1990, 30),
                new Student("Рон", 1990, 20),
                new Student("Гермиона", 1990, 50));

        List<Student> noHogwartsTeam = List.of(
                new Student("малфой", 1990, 10),
                new Student("воланд", 1960, 90),
                new Student("филч", 1930, 70)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School noHogwarts = new School("noHogwarts", noHogwartsTeam);
        List<School> schools = List.of(hogwarts, noHogwarts);


        List<Task> tasks = new ArrayList<>(List.of(
                new Task("danger", 2, 5),
                new Task("OverDanger", 3, 10)
        ));

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, tasks.get(0));
        CompletableFuture<School> noHogwartsTask = tournament.startTask(noHogwarts, tasks.get(1));

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, noHogwartsTask);

        allTasks.thenRun(() -> {

            try {
                log.info("Hogwarts Total Points: {}", hogwartsTask.get().getTotalPoints());
                log.info("NoHogwarts Total Points: {}", noHogwartsTask.get().getTotalPoints());
            } catch (InterruptedException | ExecutionException e) {
                log.error("Ошибка: {}", e.getMessage());
                throw new RuntimeException(e);
            }
        });

        allTasks.join();
        schools.stream().max(Comparator.comparingInt(School::getTotalPoints))
                .ifPresentOrElse(school -> log.info("School: {} WINS!!!!", school.getName()),
                        () -> log.info("Нет выигравших школ"));
    }
}