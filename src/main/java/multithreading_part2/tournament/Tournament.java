package multithreading_part2.tournament;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        Random rnd = new Random();
        CompletableFuture<School> schoolCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Студенты " + school.getName() + " готовы начать соревнования");
            for (Student student : school.getStudents()) {
                System.out.println("Студент " + student.getName() + " начал выполнять " + task.getName());
                try {
                    Thread.sleep(task.getDifficulty());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (rnd.nextBoolean()) {
                    System.out.println("Студент " + student.getName() + " выполнил задание " + task.getName());
                    student.setPoints(student.getPoints() + task.getReward());
                } else {
                    System.out.println("Студент " + student.getName() + " не выполнил задание " + task.getName());
                }
            }
            System.out.println("Студенты " + school.getName() + " завершили соревнования");
            return school;
        });
        return schoolCompletableFuture;
    }
}
