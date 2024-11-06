package school.faang.java.thread2.threemags;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Tournament {

    public CompletableFuture<School> startTask(School school, Task task) {
        CompletableFuture<School> schoolCompletableFuture = CompletableFuture.supplyAsync(() -> {
            new Timeout(task.difficulty());
            return new School(school.getName(),
                    school.getTeam()
                            .stream()
                            .map(student -> new Student(student.name() + " - new",
                                    student.year(),
                                    student.points() + task.reward()))
                            .collect(Collectors.toList()));
        });

        System.out.printf("\n=== All score is %d, school -  %s", school.getTotalPoints(), school);

        return schoolCompletableFuture;
    }
}