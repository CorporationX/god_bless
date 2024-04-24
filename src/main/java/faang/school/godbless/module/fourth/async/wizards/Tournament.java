package faang.school.godbless.module.fourth.async.wizards;

import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        School hogwarts = new School("hogwarts");
        hogwarts.addStudent(new Student("Biba", 2, 3));
        School beauxbatons = new School("beauxbatons");
        beauxbatons.addStudent(new Student("Boba", 1, 10));
        Task task1 = new Task("task1", 1, 150);
        Task task2 = new Task("task2", 2, 110);
        
        // Запуск заданий
        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);
        
        // Обработка результатов заданий
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.thenRun(() -> {
            if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                log.info("The winner of the magical tournament is {} with {} points.",
                         hogwarts.getName(),
                         hogwarts.getTotalPoints());
            } else if (beauxbatons.getTotalPoints() > hogwarts.getTotalPoints()) {
                log.info("The winner of the magical tournament is {} with {} points.",
                         beauxbatons.getName(),
                         beauxbatons.getTotalPoints());
            } else {
                log.info("The magical tournament ended in a tie!");
            }
        }).join();
    }
    
    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            school.getTeam().stream().forEach(student -> student.setPoints(task.getDifficulty() * task.getReward()));
            return school;
        });
    }
}
