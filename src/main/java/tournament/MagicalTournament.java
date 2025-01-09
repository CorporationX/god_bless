package tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry",
                5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur",
                6, 0), new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        hogwartsTask.thenAccept(hogwartsResult -> {
            String teamNames = hogwartsResult.getTeam().stream()
                    .map(Student::getName)
                    .collect(Collectors.joining(", "));
            log.info("{} выполнили задание '{}' и получили {} очков опыта. Студенты: {}",
                    hogwartsResult.getName(), task1.getName(), hogwartsResult.getTotalPoints(), teamNames);
        });

        beauxbatonsTask.thenAccept(beauxbatonsResult -> {
            String teamNames = beauxbatonsResult.getTeam().stream()
                    .map(Student::getName)
                    .collect(Collectors.joining(", "));
            log.info("{} выполнили задание '{}' и получили {} очков опыта. Студенты: {}",
                    beauxbatonsResult.getName(), task2.getName(), beauxbatonsResult.getTotalPoints(), teamNames);
        });

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.join();

        int hogwartsPoints = hogwarts.getTotalPoints();
        int beauxbatonsPoints = beauxbatons.getTotalPoints();

        if (hogwartsPoints > beauxbatonsPoints) {
            log.info("Победитель турнира: {}", hogwarts.getName());
        } else if (hogwartsPoints < beauxbatonsPoints) {
            log.info("Победитель турнира: {}", beauxbatons.getName());
        } else {
            log.info("Турнир завершился ничьей!");
        }
    }
}
