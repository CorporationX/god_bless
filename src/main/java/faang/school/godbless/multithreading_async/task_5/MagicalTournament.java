package faang.school.godbless.multithreading_async.task_5;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        final Tournament tournament = new Tournament();
        final School hogwarts = getHogwarts();
        final School beauxbatons = getBeauxbatonsStudents();
        final Task firstTask = new Task("Charm Lessons", Difficulty.EASY, 60);
        final Task secondTask = new Task("Herbology Exam", Difficulty.MEDIUM, 90);
        final CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, secondTask);
        final CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, firstTask);

        final CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                logTournamentWinner(hogwarts);
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                logTournamentWinner(beauxbatons);
            } else {
                log.info("The magical tournament ended in a tie!");
            }
        }).join();
        tournament.shutdownExecutor();
    }

    private static void logTournamentWinner(School school) {
        log.info("The winner of the magical tournament is {} with {} points.", school.name(),
            school.getTotalPoints());
    }

    private static School getHogwarts() {
        List<Student> hogwartsStudents = new ArrayList<>();
        hogwartsStudents.add(new Student("Harry", Year.SENIOR, 85));
        hogwartsStudents.add(new Student("Hermione", Year.JUNIOR, 70));
        hogwartsStudents.add(new Student("Ron", Year.SOPHOMORE, 90));
        hogwartsStudents.add(new Student("Draco", Year.SENIOR, 80));
        hogwartsStudents.add(new Student("Luna", Year.JUNIOR, 75));
        return new School("Hogwarts", hogwartsStudents);
    }

    private static School getBeauxbatonsStudents() {
        List<Student> beauxbatonStudents = new ArrayList<>();
        beauxbatonStudents.add(new Student("Fleur", Year.SOPHOMORE, 88));
        beauxbatonStudents.add(new Student("Gabrielle", Year.JUNIOR, 82));
        beauxbatonStudents.add(new Student("Cedric", Year.SENIOR, 95));
        beauxbatonStudents.add(new Student("Viktor", Year.SOPHOMORE, 78));
        beauxbatonStudents.add(new Student("Cho", Year.JUNIOR, 91));
        return new School("Beauxbatons", beauxbatonStudents);
    }
}