package wizards.tournament;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> teamOfHogwarts = Arrays.asList(
                new Student("Гарри Поттер", 5, 0),
                new Student("Гермиона Грейнджер", 5, 0),
                new Student("Чарли Уизли", 4, 0)
        );

        List<Student> teamOfSlytherin = Arrays.asList(
                new Student("Салазар Слизерин", 5, 0),
                new Student("Беллатриса Лестрейдж", 4, 0),
                new Student("Драко Малфой", 3, 0)
        );

        School hogwarts = new School("Хогвартс", teamOfHogwarts);
        School slytherin = new School("Слизерин", teamOfSlytherin);

        Task level1 = new Task("Спасти друзей со дна озера", 10, 100);
        Task level2 = new Task("Прочитать сообщение из яйца", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, level1);
        CompletableFuture<School> slytherinTask = tournament.startTask(slytherin, level2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, slytherinTask);

        allTasks.thenRun(() -> {
            try {
                School completedByHogwarts = hogwartsTask.get();
                School completedBySlytherin = slytherinTask.get();

                int hogwartsPoints = completedByHogwarts.getTotalPoints();
                int slytherinPoints = completedBySlytherin.getTotalPoints();

                logger.info("Школа {} набрала {} очков", completedByHogwarts.getName(), hogwartsPoints);
                logger.info("Школа {} набрала {} очков", completedBySlytherin.getName(), slytherinPoints);

                if (hogwartsPoints > slytherinPoints) {
                    logger.info("Победитель турнира: {}", completedByHogwarts.getName());
                } else if (hogwartsPoints < slytherinPoints) {
                    logger.info("Победитель турнира: {}", completedBySlytherin.getName());
                } else {
                    logger.info("Турнир завершился ничьей между {} и {}",
                            completedByHogwarts.getName(),
                            completedBySlytherin.getName());
                }

            } catch (Exception error) {
                logger.error("Ошибка", error);
            }
        }).join();

        logger.info("Турнир завершен");
    }
}
