package school.faang.magic_tournament;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final String WINNER_MESSAGE = "School {} wins with {} total scores";

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        List<Student> hogwartsTeam = Arrays.asList(new Student("Harry", 5), new Student("Hermione", 5));
        List<Student> beauxbatonsTeam = Arrays.asList(new Student("Fleur", 6), new Student("Gabrielle", 6));

        School hogwarts = new School("Hogwarts", hogwartsTeam);
        School beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        Task task1 = new Task("Triwizard Tournament", 10, 70);
        Task task2 = new Task("Yule Ball Preparations", 5, 50);

        CompletableFuture<School> hogwartsTask = tournament.startTask(hogwarts, task1);
        CompletableFuture<School> beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        CompletableFuture.allOf(hogwartsTask, beauxbatonsTask)
                .thenRun(() -> {
                    if (hogwarts.getTotalPoints() == beauxbatons.getTotalPoints()) {
                        log.info("Friendship wins");
                    }
                    if (hogwarts.getTotalPoints() > beauxbatons.getTotalPoints()) {
                        log.info(WINNER_MESSAGE, hogwarts.getName(), hogwarts.getTotalPoints());
                    } else {
                        log.info(WINNER_MESSAGE, beauxbatons.getName(), beauxbatons.getTotalPoints());
                    }
                })
                .join();
    }
}
