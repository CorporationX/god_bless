package school.faang.m1s4.bjs2_38998_threeWizards;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Tournament {
    private static final int SECONDS_TO_TERMINATION = 30;
    private static final int N_POOLS = 2;
    private final ExecutorService tournamentService = Executors.newFixedThreadPool(N_POOLS);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture
                .supplyAsync(() -> {
                    List<Student> students = school.getTeam();
                    ExecutorService taskService = Executors.newFixedThreadPool(students.size());

                    List<CompletableFuture<Student>> futureTasks = new ArrayList<>();
                    students.forEach(student -> {
                        CompletableFuture<Student> studentTask = CompletableFuture
                                .supplyAsync(() -> {
                                    System.out.printf("Student %s from %s starts %s task%n",
                                            student.getName(), school.getName(), task.getName());
                                    try {
                                        Thread.sleep(task.getDifficulty() * 1000L);
                                    } catch (InterruptedException e) {
                                        log.error("Thread has been interrupted", e);
                                    }
                                    System.out.printf("Student %s from %s earned %d points%n",
                                            student.getName(), school.getName(), task.getReward());

                                    student.setPoints(student.getPoints() + task.getReward());
                                    return student;
                                }, taskService);
                        futureTasks.add(studentTask);
                    });
                    CompletableFuture.allOf(futureTasks.toArray(new CompletableFuture[0])).join();

                    taskService.shutdown();

                    try {
                        if (!taskService.awaitTermination(SECONDS_TO_TERMINATION, TimeUnit.SECONDS)) {
                            taskService.shutdown();
                        }
                    } catch (InterruptedException e) {
                        log.error("Thread has been terminated", e);
                    }

                    return school;
                }, tournamentService);
    }

    public void shutdownPool() {
        tournamentService.shutdown();

        try {
            if (!tournamentService.awaitTermination(SECONDS_TO_TERMINATION, TimeUnit.SECONDS)) {
                tournamentService.shutdown();
            }
        } catch (InterruptedException e) {
            log.error("Thread has been terminated", e);
        }
    }

    public String defineWinner(School school1, School school2) {
        System.out.println();
        System.out.printf("%s total score: %d points%n", school1.getName(), school1.getTotalPoints());
        System.out.printf("%s total score: %d points%n", school2.getName(), school2.getTotalPoints());
        System.out.println();
        if (school1.getTotalPoints() == school2.getTotalPoints()) {
            return "Deuce!!";
        }
        System.out.printf("The winner is: %n");
        return school1.getTotalPoints() > school2.getTotalPoints() ? school1.getName() : school2.getName();
    }
}

