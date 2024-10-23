package school.faang.fourthStream.BJS2_39021;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MagicalTournament {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(
                new Student(faker.harryPotter().character(), 5, 0),
                new Student(faker.harryPotter().character(), 4, 0)
        );
        List<Student> beauxbatonsTeam = List.of(
                new Student(faker.harryPotter().character(), 6, 0),
                new Student(faker.harryPotter().character(), 3, 0)
        );

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenAccept(result -> {
            System.out.println("Tournament results:");
            System.out.println("Hogwarts: " + hogwarts.getTotalPoints());
            System.out.println("Beauxbatons: " + beauxbatons.getTotalPoints());
        }).join();
    }
}
