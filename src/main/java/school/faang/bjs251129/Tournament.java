package school.faang.bjs251129;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.Random;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        log.info("Starting task: {} for school: {}", task.getTaskName(), school.getSchool());

        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Task {} started for school: {}", task.getTaskName(), school.getSchool());
                Thread.sleep(1000L * task.getTaskDificulty());
            } catch (InterruptedException e) {
                log.error("Task interrupted", e);
            }

            for (Student student : school.getTeam()) {
                student.addPoint(task.getTaskReward());
                log.info("Added {} points to student: {}", task.getTaskReward(), student.getName());
            }
            log.info("Task {} completed for school: {}", task.getTaskName(), school.getSchool());
            return school;
        });
    }

    public CompletableFuture<Void> allTasks(List<School> schools, List<Task> tasks) {
        Random random = new Random();
        List<CompletableFuture<School>> futures = new ArrayList<>();
        for (School school : schools) {
            Task randomTask = tasks.get(random.nextInt(tasks.size()));
            futures.add(startTask(school, randomTask));
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();
        log.info("All tasks completed for all schools");
        return allOf;
    }

    public void totalPoints(List<School> schools) {
        for (School school : schools) {
            school.getTotalPoint();
        }
    }
}


