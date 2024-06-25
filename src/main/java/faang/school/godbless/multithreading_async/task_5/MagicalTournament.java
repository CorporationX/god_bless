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
                log.info("The winner of the magical tournament is {} with {} points.", hogwarts.name(), hogwarts.getTotalPoints());
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                log.info("The winner of the magical tournament is " + beauxbatons.name() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                log.info("The magical tournament ended in a tie!");
            }
        }).join();
        tournament.shutdown();
    }

    public static School getHogwarts() {
        List<Student> hogwartStudents = new ArrayList<>();
        hogwartStudents.add(new Student("Harry", Year.SENIOR, 85));
        hogwartStudents.add(new Student("Hermione", Year.JUNIOR, 70));
        hogwartStudents.add(new Student("Ron", Year.SOPHOMORE, 90));
        hogwartStudents.add(new Student("Draco", Year.SENIOR, 80));
        hogwartStudents.add(new Student("Luna", Year.JUNIOR, 75));
        return new School("Hogwarts", hogwartStudents);
    }

    public static School getBeauxbatonsStudents() {
        List<Student> beauxbatonStudents = new ArrayList<>();
        beauxbatonStudents.add(new Student("Fleur", Year.SOPHOMORE, 88));
        beauxbatonStudents.add(new Student("Gabrielle", Year.JUNIOR, 82));
        beauxbatonStudents.add(new Student("Cedric", Year.SENIOR, 95));
        beauxbatonStudents.add(new Student("Viktor", Year.SOPHOMORE, 78));
        beauxbatonStudents.add(new Student("Cho", Year.JUNIOR, 91));
        return new School("Beauxbatons", beauxbatonStudents);
    }
}