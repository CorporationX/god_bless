package school.faang.triwizard_tornament;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Student stud1 = new Student("Garry", 4);
        Student stud2 = new Student("Ron", 4);
        Student stud3 = new Student("Flear", 6);
        Student stud4 = new Student("Gabriel", 4);
        Student stud5 = new Student("Ivan", 6);
        Student stud6 = new Student("Petya", 7);

        School schoolHogwards = new School("Hogwards", List.of(stud1, stud2));
        School schoolScharl = new School("ScharlBatoon", List.of(stud3, stud4));
        School school3 = new School("3 общегородская петрозаводска", List.of(stud5, stud6));

        Task task1 = new Task("task1", 5, 5);

        CompletableFuture<School> completableFutureHogwartsTask = Tournament.startTask(schoolHogwards, task1);
        CompletableFuture<School> completableFutureScharlTask = Tournament.startTask(schoolScharl, task1);
        CompletableFuture<School> completableFutureSchool3Task = Tournament.startTask(school3, task1);

        while (!completableFutureHogwartsTask.isDone()
                || !completableFutureScharlTask.isDone()
                || !completableFutureSchool3Task.isDone()) {
            completableFutureHogwartsTask.join();
            completableFutureScharlTask.join();
            completableFutureSchool3Task.join();

        }

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(completableFutureScharlTask,
                completableFutureHogwartsTask,
                completableFutureSchool3Task);
        allTasks.thenRun(() -> {
            int pointsHogwards = schoolHogwards.getTotalPoints();
            int pointsScharlBatton = schoolScharl.getTotalPoints();
            int points3 = school3.getTotalPoints();
            int maxPoints = Math.max(Math.max(points3, pointsHogwards), pointsScharlBatton);
            if (maxPoints == pointsHogwards) {
                log.info("Студенты из {} больше всех набрали", schoolHogwards.name());
            } else {
                if (maxPoints == pointsScharlBatton) {
                    log.info("Студенты из {} больше всех набрали", schoolScharl.name());
                } else {
                    log.info("Студенты из {} больше всех набрали", school3.name());
                }
            }
        });
    }
}
