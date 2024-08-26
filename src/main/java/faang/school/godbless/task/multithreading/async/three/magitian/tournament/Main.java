package faang.school.godbless.task.multithreading.async.three.magitian.tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_SCHOOLS = 3;
    private static final int NUMBER_OF_TASKS = NUMBER_OF_SCHOOLS;
    private static final int THREAD_POOL_SIZE = NUMBER_OF_SCHOOLS;

    private static final Tournament tournament = new Tournament(THREAD_POOL_SIZE);
    private static final List<CompletableFuture<School>> futures = new ArrayList<>();
    private static CompletableFuture<Void> allTasks;
    private static final SchoolTaskFabric fabric = new SchoolTaskFabric(NUMBER_OF_SCHOOLS, NUMBER_OF_TASKS);
    private static List<School> schools;
    private static List<Task> tasks;

    public static void main(String[] args) {
        defaultInit();
        futures.addAll(runTask());
        printWinners();
        tournament.shutdownExecutor();
    }

    private static void defaultInit() {
        schools = fabric.getSchools();
        tasks = fabric.getTasks();
    }

    private static List<CompletableFuture<School>> runTask() {
        return IntStream
                .range(0, NUMBER_OF_SCHOOLS)
                .mapToObj(i -> tournament.startTask(schools.get(i), tasks.get(i)))
                .toList();
    }

    private static void printWinners() {
        allTasks = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allTasks.thenRun(Main::printSchool);
    }

    private static void printSchool() {
        var winnerSchool = getWinner();
        log.info("{} won", winnerSchool.getName());
    }

    private static School getWinner() {
        return schools
                .stream()
                .max(Comparator.comparingLong(School::getTotalPoints))
                .orElseThrow();
    }
}
