package faang.school.godbless.async.task_5.model;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        List<Student> students = school.getStudents();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(students.size());
        students.forEach(student -> {
            futures.add(
            CompletableFuture.runAsync(() -> student.startTask(task), executor));
        });
        CompletableFuture<School> futureSchool = CompletableFuture.supplyAsync(() -> {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
            return school;
            }, executor);
        executor.shutdown();
        return futureSchool;
    }
}