package school.faang.BJS2_62400;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();
        List<School> schools = new ArrayList<>();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        List<Student> durmstrangTeam = List.of(new Student("Viktor", 6, 0), new Student("Igor", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);
        School durmstrang = new School("Durmstrang", durmstrangTeam);

        schools.add(hogwarts);
        schools.add(beauxbatons);
        schools.add(durmstrang);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);
        Task task3 = new Task("Do not breathe underwater", 10, 80);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task2);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task3);
        CompletableFuture<School> durmstrangTask = tournament.startTask(durmstrang, task1);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask, durmstrangTask);
        allTasks.thenRun(() -> {
            schools.forEach(school -> log.info(ConstAndMessages.SCHOOL_TOTAL_POINTS,
                    school.getName(), school.getTotalPoints()));
            schools.stream().max(Comparator.comparingInt(School::getTotalPoints))
                    .ifPresentOrElse(s -> log.info(ConstAndMessages.WINNER_TOURNAMENT, s.getName()),
                            () -> log.info(ConstAndMessages.WINNER_NOT_DETERMINED));
        });
        allTasks.join();

        tournament.shutdown();
    }

}
