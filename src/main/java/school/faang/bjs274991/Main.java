package school.faang.bjs274991;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<School> schools = List.of(
                new School("potterShool", Arrays.asList(
                        new Student("Garry", 3),
                        new Student("Germiona", 3)
                )),
                new School("shmotterShool", Arrays.asList(
                        new Student("Shmary", 2),
                        new Student("Shermiona", 2)
                )),
                new School("motterShool", Arrays.asList(
                        new Student("Mary", 1),
                        new Student("Marmiona", 1)
                ))
        );

        List<Task> tasks = List.of(
                new Task("Triwizard Tournament", 10, 100),
                new Task("Yule Ball Preparations", 5, 50),
                new Task("One more stupid game", 7, 75)
        );

        List<CompletableFuture<School>> futures = new ArrayList<>();
        for (School school : schools) {
            for (Task task : tasks) {
                CompletableFuture<School> future = tournament
                        .startTask(school, task);
                futures.add(future);
            }
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .join();

        System.out.println("Total points:");
        for (School school : schools) {
            System.out.printf("%s get %d points (%d)\n",
                    school.getName(), school.getTotalPoints(), school.getFinishTime());
        }

        Comparator<School> cmp = Comparator
                .comparingInt(School::getTotalPoints).reversed()
                .thenComparingLong(School::getFinishTime).reversed();
        School winner = schools.stream()
                .max(cmp)
                .orElseThrow();

        System.out.printf("Winner: %s because they was faster\n", winner.getName());

        tournament.shutdown();
    }
}
