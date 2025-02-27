package school.faang.tournament_wizzards;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {

    public static void main(String[] args) {
        List<Student> griffindorTeam = List.of(new Student("Harry", 3, 0),
                new Student("Ron", 3, 0));
        List<Student> slytherinTeam = List.of(new Student("Hermione", 4, 0),
                new Student("Thomas", 2, 0));

        School griffindor = new School("Griffindor", griffindorTeam);
        School slytherin = new School("Slytherin", slytherinTeam);

        Task task1 = new Task("Triwizard Tournament", Difficulty.MEDIUM, 100);
        Task task2 = new Task("Yule Ball Preparations", Difficulty.HARD, 150);

        CompletableFuture<School> griffindorTask = Tournament.startTask(griffindor, task1);
        CompletableFuture<School> slytherinTask = Tournament.startTask(slytherin, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(griffindorTask, slytherinTask);

        allTasks.thenRun(() -> {
            if (griffindor.getTotalPoints() > slytherin.getTotalPoints()) {
                log.info(griffindor.name() + " одерживает победу!");
            } else if (griffindor.getTotalPoints() < slytherin.getTotalPoints()) {
                log.info(slytherin.name() + " одерживает победу!");
            } else {
                log.info("Ничья!");
            }
        });

        allTasks.join();
    }

    public static CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            for (Student student : school.team()) {
                student.setPoints(student.getPoints() + task.getReward());
                log.info("Ученик:" + student.getName() + " зарабатывает : " + task.getReward() + " очков.");
            }

            log.info("Школа: " + school.name() + " получила: " + school.getTotalPoints() + " очков.");
            return school;
        });
    }
}
