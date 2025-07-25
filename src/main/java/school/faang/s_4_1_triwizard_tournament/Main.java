package school.faang.s_4_1_triwizard_tournament;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        School hogwarts = new School("Hogwarts");
        School slitherine = new School("Slitherin");
        School beauxbatons = new School("Beauxbatons");
        List<Student> hogwartsTeam = new ArrayList<>(Arrays.asList(
                new Student("Harry", 5),
                new Student("Mary", 6),
                new Student("Hermione", 6)));
        List<Student> beauxbatonsTeam = new ArrayList<>(Arrays.asList(
                new Student("Fleur", 5),
                new Student("Gabrielle", 6),
                new Student("Vie", 6)));
        List<Student> slitherineTeam = new ArrayList<>(Arrays.asList(
                new Student("Late", 5),
                new Student("Mouse", 6),
                new Student("Waide", 6)));
        hogwartsTeam.stream()
                .forEach(student -> hogwarts.addStudent(student));
        beauxbatonsTeam.stream()
                .forEach(student -> beauxbatons.addStudent(student));
        slitherineTeam.stream()
                .forEach(student -> slitherine.addStudent(student));
        Task task1 = new Task("Jumps", 1, 20);
        Task task2 = new Task("Magics Spell", 2, 30);
        Task task3 = new Task("Triwizard Tournament", 10, 100);
        Task task4 = new Task("Yule Ball Preparations", 5, 50);
        List<School> schools = Arrays.asList(hogwarts, slitherine, beauxbatons);
        Tournament.startTaskEverySchool(schools, task1);

        Tournament.startTask(beauxbatons, task2).join();

        // НАДО КОНЕЧНО ПРОВЕРИТЬ РЕЗУЛЬТАТЫ ЗАДАЧ!!!
        schools.stream().forEach(school -> System.out.println("School " + school.getName() +
                " reached " + school.getTotalPoints() + " points"));

        String winner = Tournament.findWinner(List.of(hogwarts, slitherine, beauxbatons));
        System.out.println("Congratulations! The winner of the competition is " + winner);

        Tournament.shutdown();
    }
}
