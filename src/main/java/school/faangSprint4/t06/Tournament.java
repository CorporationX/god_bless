package school.faangSprint4.t06;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.printf("School %s started task: %s%n",
                        school.name(), task.name());
                Thread.sleep(task.difficulty() * 1000L);

                for (Student student : school.team()) {
                    student.addPoints(task.reward());
                    System.out.printf("Student %s from %s earned %d points%n",
                            student.getName(), school.name(), task.reward());
                }

                System.out.printf("School %s completed task: %s%n",
                        school.name(), task.name());

                return school;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}