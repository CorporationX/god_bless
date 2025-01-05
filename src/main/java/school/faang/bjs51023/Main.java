package school.faang.bjs51023;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Tournament tournament = new Tournament();

        List<CompletableFuture<School>> completedTasks = new ArrayList<>();
        Student Ron = new Student("Ron", 1);
        Student Harry = new Student("Harry", 5);
        Student Hermione = new Student("Hermione", 5);
        Student Draco = new Student("Draco", 4);
        Student Luna = new Student("Luna", 3);

        School hogwarts = new School("Hogwarts", new ArrayList<>(List.of(Ron, Harry, Hermione)));
        School durmstrang = new School("Durmstrang", new ArrayList<>(List.of(Draco, Luna)));

        Task quest1 = new Task("Triwizard Tournament", 5, 200);
        Task quest2 = new Task("Magical Creatures Hunt", 1, 150);
        Task quest3 = new Task("Potion Brewing Contest", 3, 100);

        completedTasks.add(tournament.startTask(hogwarts, quest1));
        completedTasks.add(tournament.startTask(durmstrang, quest2));
        completedTasks.add(tournament.startTask(durmstrang, quest3));
        completedTasks.add(tournament.startTask(hogwarts, quest3));

        var allTasks = CompletableFuture.allOf(completedTasks.toArray(new CompletableFuture[4]));
        allTasks.get();
        allTasks.thenRun(() -> {
            int hogwartsPoints = hogwarts.getTotalPoints();
            int durmstrangPoints = durmstrang.getTotalPoints();
            if (hogwartsPoints > durmstrangPoints) {
                log.info("Hogwarts won");
            } else if (hogwartsPoints == durmstrangPoints) {
                log.info("Draw");
            } else {
                log.info("Durmstrang won");
            }
        });
    }
}
