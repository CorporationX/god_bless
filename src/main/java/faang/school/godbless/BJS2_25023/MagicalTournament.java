package faang.school.godbless.BJS2_25023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        var schools = creatSchool();
        Tournament tournament = new Tournament();

        var task1 = new Task("Task1", 5, 10);
        var task2 = new Task("Task2", 4, 12);
        var task3 = new Task("Task3", 5, 1);



        var hogwartsTask = tournament.startTask(schools.get(0), task1);
        var beauxbatonsTask = tournament.startTask(schools.get(1), task2);
        var mahoutokoroTask = tournament.startTask(schools.get(2), task3);

        var allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask, mahoutokoroTask);
        allTasks.thenRun(() -> {
            if (schools.get(0).getTotalPoints() > schools.get(1).getTotalPoints() && schools.get(0).getTotalPoints() > schools.get(2).getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + schools.get(0).getName() + " with " + schools.get(0).getTotalPoints() + " points.");
            } else if (schools.get(1).getTotalPoints() > schools.get(0).getTotalPoints() && schools.get(1).getTotalPoints() > schools.get(2).getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + schools.get(1).getName() + " with " + schools.get(1).getTotalPoints() + " points.");
            } else if (schools.get(2).getTotalPoints() > schools.get(0).getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + schools.get(2).getName() + " with " + schools.get(2).getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();
    }

    private static List<School> creatSchool() {
        return new ArrayList<>(
                List.of(
                        new School(
                                "Hogwarts", new ArrayList<>(
                                List.of(
                                        new Student("Harry", 1994, 0),
                                        new Student("Hermione", 1994, 0),
                                        new Student("Ron", 1994, 0)
                                ))),
                        new School("Beauxbatons", new ArrayList<>(
                                List.of(
                                        new Student("Paul", 1994, 0),
                                        new Student("Lisa", 1994, 0),
                                        new Student("Cristine", 1994, 0)
                                )
                        )),
                        new School("Mahoutokoro", Arrays.asList(
                                new Student("John", 1994, 0),
                                new Student("Jack", 1994, 0),
                                new Student("Mike", 1994, 0)
                        ))
                )
        );
    }
}