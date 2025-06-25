package school.faang.bjs2_82772;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", DifficultyTask.IMPOSSIBLE, 100);
        Task task2 = new Task("Yule Ball Preparations", DifficultyTask.HARD, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        List<CompletableFuture<School>> tasks = new ArrayList<>(List.of(hogwartsTask, beauxbatonsTask));

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]))
                .thenApply((v) -> tasks.stream()
                        .map(CompletableFuture::join)
                        .sorted(Comparator.comparing(School::getTotalPoints).reversed())
                        .toList()
                )
                .thenAccept(schools -> {
                    log.info("Победитель: {}!", schools.get(0).getName());
                    for (int i = 0; i < schools.size(); i++) {
                        School school = schools.get(i);
                        log.info("{} место заняла школа {} в составе: {}",
                                i + 1,
                                school.getName(),
                                school.getTeam().stream()
                                        .map(Student::getName)
                                        .collect(Collectors.joining(", ")));
                    }
                });

        tournament.breakPoolThread();
    }
}
