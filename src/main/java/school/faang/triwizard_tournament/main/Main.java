package school.faang.triwizard_tournament.main;

import school.faang.triwizard_tournament.main_code.School;
import school.faang.triwizard_tournament.main_code.Student;
import school.faang.triwizard_tournament.main_code.Task;
import school.faang.triwizard_tournament.main_code.Tournament;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsFuture = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsFuture = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTask = CompletableFuture.allOf(hogwartsFuture, beauxbatonsFuture);

        allTask.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println(hogwarts.getName() + " победитель");
            } else {
                System.out.println(beauxbatons.getName() + "победитель");
            }
        }).join();
    }
}
