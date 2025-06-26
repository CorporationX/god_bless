package school.faang.wizards;

import lombok.extern.slf4j.Slf4j;
import school.faang.wizards.domain.School;
import school.faang.wizards.domain.Student;
import school.faang.wizards.domain.Task;
import school.faang.wizards.exception.WinnerNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author Danil Pudovkin
 * @since 26.06.2025
 */
@Slf4j
public class MagicalTournament {

    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        var hogwartsTeam = List.of(new Student("Harry", 5, 0), new Student("Hermione", 5, 0));
        var beauxbatonsTeam = List.of(new Student("Fleur", 6, 0), new Student("Gabrielle", 6, 0));
        var hogwarts = new School("Hogwarts", hogwartsTeam);
        var beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        var task1 = new Task("Triwizard Tournament", 10, 100);
        var task2 = new Task("Yule Ball Preparations", 5, 50);

        var hogwartsTask = tournament.startTask(hogwarts, task1);
        var beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        var allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);

        allTasks.thenRun(() -> {
            var school = Stream.of(hogwartsTask.join(), beauxbatonsTask.join())
                    .max(Comparator.comparingDouble(School::getTotalPoints))
                    .orElseThrow(WinnerNotFoundException::new);
            log.info("Победила команда школы {}!", school.getName());
        }).join();
    }
}
