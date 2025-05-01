package school.faang.bjs2_74824;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);


        Task task1 = Task.builder()
                .name("Triwizard Tournament")
                .difficulty(10)
                .reward(100)
                .build();
        Task task2 = Task.builder()
                .name("Yule Ball Preparations")
                .difficulty(5)
                .reward(50)
                .build();

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        School winner = hogwartsTask.thenCombine(beauxbatonsTask,
                        (school1, school2) -> school1.getTotalPoints() >= school2.getTotalPoints() ? school1 : school2)
                .join();

        log.info("{} school has won with {} points", winner.getName(), winner.getTotalPoints());
    }
}
