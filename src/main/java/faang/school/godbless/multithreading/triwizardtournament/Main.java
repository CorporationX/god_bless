package faang.school.godbless.multithreading.triwizardtournament;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        List<Student> hogwartsStudents = List.of(
                new Student("Harry Potter", 5, 85),
                new Student("Hermione Granger", 5, 95),
                new Student("Ron Weasley", 5, 70),
                new Student("Draco Malfoy", 5, 60),
                new Student("Luna Lovegood", 4, 80),
                new Student("Neville Longbottom", 5, 65),
                new Student("Ginny Weasley", 4, 90),
                new Student("Fred Weasley", 7, 75),
                new Student("George Weasley", 7, 75),
                new Student("Cedric Diggory", 7, 85)
        );

        List<Student> durmstrangStudents = List.of(
                new Student("Viktor Krum", 6, 90),
                new Student("Igor Karkaroff", 7, 70),
                new Student("Antonin Dolohov", 6, 65),
                new Student("Gellert Grindelwald", 7, 100),
                new Student("Igor Raskolnikov", 5, 60),
                new Student("Sergei Ivanov", 4, 55),
                new Student("Boris Bulgakov", 5, 75),
                new Student("Nikolai Volkov", 6, 85),
                new Student("Dimitri Petrov", 5, 80),
                new Student("Ivan Kuznetsov", 4, 70)
        );

        List<Student> beauxbatonsStudents = List.of(
                new Student("Fleur Delacour", 6, 95),
                new Student("Gabrielle Delacour", 4, 80),
                new Student("Apollline Delacour", 7, 85),
                new Student("Isabella Beauregard", 5, 70),
                new Student("Claude Dupont", 6, 75),
                new Student("Juliette Bonnet", 5, 65),
                new Student("Sophie Dubois", 4, 60),
                new Student("Henri Moreau", 6, 90),
                new Student("Marcel Lefevre", 5, 80),
                new Student("Lucienne Durand", 7, 85)
        );


        List<School> schools = List.of(
                new School("Hogwarts", hogwartsStudents),
                new School("Durmstrang", durmstrangStudents),
                new School("Beauxbatons", beauxbatonsStudents)
        );


        List<Task> tasks = List.of(
                new Task("Defeat the Dark Lord", 10, 100),
                new Task("Win the Quidditch Cup", 7, 75),
                new Task("Brew a Polyjuice Potion", 8, 90),
                new Task("Find the Sorcerer's Stone", 9, 95),
                new Task("Escape from the Forbidden Forest", 6, 80),
                new Task("Rescue Sirius Black", 8, 85),
                new Task("Attend the Yule Ball", 5, 60),
                new Task("Win the Triwizard Tournament", 9, 100),
                new Task("Destroy a Horcrux", 10, 100),
                new Task("Learn the Patronus Charm", 7, 70)
        );

        Tournament tournament = new Tournament();

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        CompletableFuture<School>[] completableFutures = new CompletableFuture[3];

        for (int i = 0; i < completableFutures.length; i++) {
            int randomTaskIndex = ThreadLocalRandom.current().nextInt(tasks.size());
            completableFutures[i] = tournament.startTask(schools.get(i), tasks.get(randomTaskIndex), threadPool);
        }

        for (int i = 0; i < completableFutures.length; i++) {
            int randomTaskNumber = ThreadLocalRandom.current().nextInt(0, tasks.size());
            completableFutures[i] = tournament.startTask(schools.get(i), tasks.get(randomTaskNumber), threadPool);
        }

        CompletableFuture.allOf(completableFutures)
                .thenApply(v -> Arrays.stream(completableFutures)
                        .map(CompletableFuture::join)
                        .max(Comparator.comparingInt(School::getTotalPoints))
                        .orElseThrow())
                .thenAccept(school -> System.out.printf("The winner of the magical tournament is %s with %d points%n\n",
                        school.getName(), school.getTotalPoints()))
                .join();

        threadPool.shutdown();
    }
}
