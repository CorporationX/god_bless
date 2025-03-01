package school.faang.task_62430;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final Random RANDOM = new Random();
    private static final String HOGWARTS_WINS = "Hogwarts wins!!!!!!";
    private static final String BEAUXBATONS_WINS = "Beauxbatons wins!!!!!!";
    private static int monetka;

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        List<Student> beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 100);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                        log.info(HOGWARTS_WINS);
                    } else if (hogwarts.getTotalPoints() == beauxbatons.getTotalPoints()) {
                        monetka = RANDOM.nextInt(0, 2);
                        if (monetka == 0) {
                            log.info(HOGWARTS_WINS);
                        } else {
                            log.info(BEAUXBATONS_WINS);
                        }
                    } else {
                        log.info(BEAUXBATONS_WINS);
                    }
                });
        allTasks.join();
    }
}