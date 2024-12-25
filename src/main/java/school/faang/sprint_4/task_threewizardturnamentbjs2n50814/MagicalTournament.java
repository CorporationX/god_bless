package school.faang.sprint_4.task_threewizardturnamentbjs2n50814;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание школ
        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0),
                new Student("Herberd", 4, 0)
        );
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0),
                new Student("Bob", 5, 0)
        );
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        // Создание заданий
        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 7, 70);

        // Запуск заданий для школ
        System.out.println("Main() thread works 0....");
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        System.out.println("Main() thread works 1....");

        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
        System.out.println("Main() thread works 2....");
        //CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        //allTasks.join();
        // Обработка результатов всех заданий и определение победителя

        Student bestInHogwards = hogwarts.getTeam().stream()
                .max(Comparator.comparing(Student::getPoints)).orElse(new Student("N", 0, 0));

        Student bestInBeauxbatons = beauxbatons.getTeam().stream()
                .max(Comparator.comparing(Student::getPoints)).orElse(new Student("N", 0, 0));

        if (bestInHogwards.getPoints() > bestInBeauxbatons.getPoints()) {
            log.info("'{}' from Hogwards has won with {} points",
                    bestInHogwards.getName(), bestInHogwards.getPoints());
        } else {
            log.info("'{}' from Beauxbatons has won with {} points",
                    bestInBeauxbatons.getName(), bestInBeauxbatons.getPoints());
        }

        log.info("'{}' team ----------------------", hogwarts.getName());
        for (Student student : hogwarts.getTeam()) {
            log.info("'{}' from Hogwards has {} points", student.getName(), student.getPoints());
        }

        log.info("'{}' team ----------------------", beauxbatons.getName());
        for (Student student : beauxbatons.getTeam()) {
            log.info("'{}' from Hogwards has {} points", student.getName(), student.getPoints());
        }
    }
}
