package tournament;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        var schools = initSchools();
        var tasks = initTasks();
        Tournament tournament = new Tournament(schools.size());
        CompletableFuture<School>[] schoolsTasks = new CompletableFuture[schools.size()];
        IntStream.range(0, schools.size())
                .forEach(i -> schoolsTasks[i] = tournament.startTask(schools.get(i), tasks.get(i)));
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(schoolsTasks);
        allTasks.thenRun(() -> printWinner(schools))
                .join();
        tournament.finishTournament();
    }

    private static List<School> initSchools() {
        List<School> schools = new ArrayList<>();
        schools.add(new School("Hogwarts", List.of(
                new Student("Harry Potter", 4),
                new Student("Cedric Diggory", 5),
                new Student("Draco Malfoy", 4)
        )));
        schools.add(new School("Beauxbatons", List.of(
                new Student("Aurélie Dumont", 5),
                new Student("Fleur Delacour", 5),
                new Student("Celine Castillon", 4)
        )));
        schools.add(new School("Durmstrang", List.of(
                new Student("Viktor Krum", 5),
                new Student("Gruffyd Wellnelly", 5),
                new Student("Baglan Wellnelly", 5)
        )));
        return schools;
    }

    private static List<Task> initTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Get dragon egg", 3, 5));
        tasks.add(new Task("Complete labyrinth", 2, 6));
        tasks.add(new Task("Win the duel", 3, 3));
        return tasks;
    }

    private static void printWinner(@NonNull List<School> schools) {
        var orderedSchools = schools.stream()
                .sorted(Comparator.comparing(School::getTotalPoints).reversed())
                .toList();
        if (orderedSchools.size() > 1) {
            if (orderedSchools.get(0).getTotalPoints() != orderedSchools.get(1).getTotalPoints()) {
                School winner = orderedSchools.get(0);
                log.info(String.format("The winner of the magical tournament is %s with %d points!",
                        winner.getName(), winner.getTotalPoints()));
            } else {
                log.info("The magical tournament ended in a tie!");
            }
        } else {
            School winner = orderedSchools.get(0);
            log.info(String.format("We have only one competitor! " +
                            "Winner of the magical tournament is %s with %d points!",
                    winner.getName(), winner.getTotalPoints()));
        }
    }
}
