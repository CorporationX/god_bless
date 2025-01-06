package school.faang.sprint_4.task_43582;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    private static final long THREAD_SLEEP = 1_000;
    private static final Random RANDOM = new Random();

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Школа " + school.name() + " приступила к выполнению " + task.name());
            try {
                Thread.sleep(THREAD_SLEEP * task.difficulty());
            } catch (InterruptedException e) {
                System.out.println("Школа " + school.name() + " прервала выполнение задания " + task.name());
            }

            int reward = task.reward() / school.team().size();
            for (Student student : school.team()) {
                student.setPoints(student.getPoints() + reward);
                System.out.println("Студент " + student.getName() + " набрал " + reward + " очков");
            }
            return school;
        });
    }
}
