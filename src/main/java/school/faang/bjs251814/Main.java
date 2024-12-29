package school.faang.bjs251814;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws Exception {
        final long start = System.currentTimeMillis();
        System.out.println("main started");
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0),
                new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0),
                new Student("Gabrielle", 6, 0));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        School school = hogwartsTask.get();
        System.out.println(school.getName() + " : " + school.getTotalPoints());
        School school1 = beauxbatonsTask.get();
        System.out.println(school1.getName() + " : " + school1.getTotalPoints());

        System.out.println("main finished");
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }
}
