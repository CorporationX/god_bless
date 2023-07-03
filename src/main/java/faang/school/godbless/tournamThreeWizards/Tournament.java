package faang.school.godbless.tournamThreeWizards;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            school.getTeam().forEach(student -> student.setPoints(student.getPoints() + task.getReward()));

            return school;
        });
    }

    public static void printResults(School hogwarts, School beauxbatons, Task task1, Task task2) {
        System.out.println("Task [" + task1.getName() + "] completed by--> " + hogwarts.getName() + " with: " + hogwarts.getTotalPoints() + " points");
        System.out.println("Task [" + task2.getName() + "] completed by--> " + beauxbatons.getName() + " with: " + beauxbatons.getTotalPoints() + " points");

        if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
            System.out.println("The winner of the magical tournament is: " + hogwarts.getName());
        } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
            System.out.println("The winner of the magical tournament is: " + beauxbatons.getName());
        }
    }

}
