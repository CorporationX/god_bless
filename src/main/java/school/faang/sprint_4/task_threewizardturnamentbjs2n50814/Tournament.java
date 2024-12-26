package school.faang.sprint_4.task_threewizardturnamentbjs2n50814;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Tournament {
    private static int DEFAULT_DELAY = 400;

    public CompletableFuture<School>  startTask(School school, Task task) {
        CompletableFuture<School> executorFuture = CompletableFuture.supplyAsync(() -> doTournament(school, task));
        return executorFuture;
    }

    private School doTournament(@NonNull School school, @NonNull Task task) {
        log.info("startTask {}, {}", school, task);
        int randomStudent = (int) (Math.random() * school.getTeam().size());
        school.getTeam().get(randomStudent)
                .addPoints(task.getReward());
        try {
            Thread.sleep((long) DEFAULT_DELAY * task.getDifficulty());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return school;
    }

    public static School findWinner(List<School> schools) {

        Comparator<School> compareSchools = new Comparator<School>() {
            @Override
            public int compare(School o1, School o2) {
                int o1PointsSum = 0;
                int o2PointsSum = 0;
                for (int i = 0; i < o1.getTeam().size(); i++) {
                    o1PointsSum += o1.getTeam().get(i).getPoints();
                }
                for (int i = 0; i < o2.getTeam().size(); i++) {
                    o2PointsSum += o2.getTeam().get(i).getPoints();
                }
                if (o1PointsSum > o2PointsSum) {
                    return 1;
                } else if (o1PointsSum < o2PointsSum) {
                    return -1;
                } else {return 0;}
            }
        };
        return schools.stream()
                .max(compareSchools)
                .orElse(new School("ExceptionSchool", List.of()));
    }
}
