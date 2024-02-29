package faang.school.godbless.multithreading_async.wizards;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tournament {
    private static ExecutorService executorService;

    public Tournament() {
        executorService = Executors.newFixedThreadPool(4);
    }

    public CompletableFuture<School> startTask(School school, Task task){
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("%s начинает выполнять задание %s%n", school.getName(), task.getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            updateTeamPointSchool(school, task);
            return school;

        }, executorService);
    }

    private static void updateTeamPointSchool(School school, Task task){
        List<Student> modifiedStudents = school.getTeam().stream()
                .peek(student -> student.setPoints(student.getPoints() + task.getReward()))
                .toList();
        school.setTeam(modifiedStudents);
    }

    public void shutdownExecutorService(){
        executorService.shutdown();
    }
}
