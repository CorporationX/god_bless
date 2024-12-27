package school.faang.sprint4.bjs_50995;

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

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask).join();

        pickWinner(hogwarts, beauxbatons);
    }

    private static void pickWinner(School school1, School school2) {
        if (school1.getTotalPoints() > school2.getTotalPoints()) {
            printWinner(school1);
        } else if (school1.getTotalPoints() < school2.getTotalPoints()) {
            printWinner(school2);
        } else {
            log.info("Ничья!");
        }
    }

    private static void printWinner(School school) {
        log.info("Команда {} победила в турнире!", school.getName());
    }
}
