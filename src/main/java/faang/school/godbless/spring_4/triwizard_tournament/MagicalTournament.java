package faang.school.godbless.spring_4.triwizard_tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class MagicalTournament {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Tournament tournament = new Tournament();

        Supplier<List<Student>> randomStudents = () -> {

            char[] chars = {'r', 'u', 'v', 'i', 'q', 'b', 'p', 'j', 'a', 'x', 'm', 'd', 'k', 'o', 'e', 'a'};

            Supplier<String> name = () -> {

                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < new Random().nextInt(3, 8); i++) {
                    builder.append(chars[new Random().nextInt(chars.length)]);
                }

                return builder.toString();
            };

            List<Student> students = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                students.add(new Student(name.get(), new Random().nextInt(5), new Random().nextInt(1, 101)));
            }
            return students;
        };

        Task catchTheDragon = new Task("Dragon", 45, 90);

        School hogwarts = new School("Hogwarts", randomStudents.get());
        School beauxbatons = new School("Beauxbatons", randomStudents.get());

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, catchTheDragon);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, catchTheDragon);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + hogwarts.getName() + " with " + hogwarts.getTotalPoints() + " points.");
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                System.out.println("The winner of the magical tournament is " + beauxbatons.getName() + " with " + beauxbatons.getTotalPoints() + " points.");
            } else {
                System.out.println("The magical tournament ended in a tie!");
            }
        }).join();

    }
}
