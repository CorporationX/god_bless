package com.multithreading.tournament;

import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Student cedric = new Student("Cedric", 1989);
        Student zhou = new Student("Zhou", 1979);
        Student harry = new Student("Harry", 1980);

        Student aurelie = new Student("Aurelie", 1977);
        Student gabrielle = new Student("Gabrielle", 1985);
        Student fleur = new Student("Fleur", 1977);

        School hogwarts = new School("Hogwarts");
        hogwarts.addStudent(cedric);
        hogwarts.addStudent(zhou);
        hogwarts.addStudent(harry);

        School beauxbatons = new School("Beauxbatons");
        beauxbatons.addStudent(aurelie);
        beauxbatons.addStudent(gabrielle);
        beauxbatons.addStudent(fleur);

        Task task = new Task("The battle with the dragon", 4);
        Tournament tournament = new Tournament();

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " +
                        hogwarts.getName() +
                        " with " +
                        hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " +
                        beauxbatons.getName() +
                        " with " + beauxbatons.getTotalPoints() +
                        " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();

    }
}
