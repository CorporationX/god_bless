package tournament_of_three_wizards;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

class Tournament {
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Task " + task.getName() + " started for school " + school.getName());
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int earnedPoints = ThreadLocalRandom.current().nextInt(1, 11);

            school.getTeam().forEach(student -> student.earnPoints(earnedPoints));

            System.out.println("Task " + task.getName() + " completed for school " + school.getName());

            return school;
        });
    }
}
