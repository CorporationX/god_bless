package school.faang.task_62436;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final String COMPLETED_TASK_MESSAGE
            = "Команда школы \"{}\" выполнила задание и теперь имеет в сумме {} очков.";
    private static final String ANNOUNCE_WINNER_MESSAGE = "Школа \"{}\" победила в турнире!";
    private static final String EQUALITY_POINTS_MESSAGE
            = "Школа \"{}\" и школа \"{}\" набрали равное количество очков - {}. Готовьтесь к дополнительному заданию!";

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 100);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        hogwartsTask.thenAccept(Main::completingTask);
        beauxbatonsTask.thenAccept(Main::completingTask);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                        announceWinner(hogwarts);
                    } else if (hogwarts.getTotalPoints() < beauxbatons.getTotalPoints()) {
                        announceWinner(beauxbatons);
                    } else {
                        equalityOfPoints(hogwarts, beauxbatons);
                    }
                })
                .join();
    }

    private static void completingTask(School school) {
        log.info(COMPLETED_TASK_MESSAGE, school.getName(), school.getTotalPoints());
    }

    private static void announceWinner(School school) {
        log.info(ANNOUNCE_WINNER_MESSAGE, school.getName());
    }

    private static void equalityOfPoints(School firstSchool, School secondSchool) {
        log.info(EQUALITY_POINTS_MESSAGE, firstSchool.getName(), secondSchool.getName(), firstSchool.getTotalPoints());
    }
}
