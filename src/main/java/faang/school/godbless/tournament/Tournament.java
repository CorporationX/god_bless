package faang.school.godbless.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) throws InterruptedException {
        CompletableFuture<School> result = CompletableFuture.supplyAsync(() -> {
            List<Student> students = school.getTeam();
            students.forEach(student -> {
                Integer points = student.getPoints();
                student.setPoints(points + 1);
            });
            school.setTeam(students);
            return school;
        });
        return result;
    }
}
