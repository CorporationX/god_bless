package school.faang.sprint_4.task_threewizardturnamentbjs2n50814;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static int DEFAULT_DELAY = 400;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> doTournament(school, task));
    }

    private School doTournament(@NonNull School school, @NonNull Task task) {
        log.info("startTask for {}", school.getName());
        int randomStudent = (int) (Math.random() * school.getTeam().size());
        school.getTeam().get(randomStudent)
                        .addPoints(task.getReward());
        try {
            Thread.sleep((long) DEFAULT_DELAY * task.getDifficulty());
        } catch (InterruptedException e) {
           log.error(e.getMessage());
        }
        return school;
    }

    public static School findWinner(List<School> schools) {

        Comparator<School> compareSchools = new Comparator<School>() {
            @Override
            public int compare(School o1, School o2) {
                int o1PointsSum = o1.getTeam().stream()
                        .mapToInt(Student::getPoints)
                        .sum();

                int o2PointsSum = o2.getTeam().stream()
                        .mapToInt(Student::getPoints)
                        .sum();

                return Integer.compare(o1PointsSum, o2PointsSum);
            }
        };
        return schools.stream()
                .max(compareSchools)
                .orElse(new School("ExceptionSchool", List.of()));
    }
}
