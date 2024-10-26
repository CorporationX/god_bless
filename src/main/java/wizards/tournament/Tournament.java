package wizards.tournament;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class Tournament {
    private final Logger logger = LoggerFactory.getLogger(Tournament.class);

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> executeTask(school, task));
    }

    private School executeTask(School school, Task task) {
        try {
            logger.info("Школа {} начала выполнение задания {}", school.getName(), task.getName());

            Thread.sleep(task.getDifficulty() + 1000L);

            int trophyPerStudent = task.getTrophy() / school.getTeam().size();
            school.getTeam().forEach(student -> {
                int updatedPoints = student.getPoints() + trophyPerStudent;
                student.setPoints(updatedPoints);
                logger.info("Студент {} из школы {} получил {} очков. У него сейчас: {} очков.",
                        student.getName(),
                        school.getName(),
                        trophyPerStudent,
                        student.getPoints()
                );
            });

            logger.info("Школа {} завершила выполнение задания {}",
                    school.getName(),
                    task.getName());

            return school;
        } catch (InterruptedException error) {
            logger.error("Задание {} для школы {} было прервано", task.getName(), school.getName(), error);
            throw new RuntimeException(error);
        }
    }
}
