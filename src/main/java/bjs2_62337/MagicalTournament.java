package bjs2_62337;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class MagicalTournament {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();

        // Создание школ
        var hogwartsTeam = List.of(
                new Student("Harry", 5),
                new Student("Hermione", 5));
        var beauxbatonsTeam = List.of(
                new Student("Fleur", 6),
                new Student("Gabrielle", 6));
        var hogwarts = new School("Hogwarts", hogwartsTeam);
        var beauxbatons = new School("Beauxbatons", beauxbatonsTeam);

        // Создание заданий
        var task1 = new Task("Triwizard Tournament", 10, 100);
        var task2 = new Task("Yule Ball Preparations", 5, 50);

        // Запуск заданий для школ
        var hogwartsTask = tournament.startTask(hogwarts, task1);
        var beauxbatonsTask = tournament.startTask(beauxbatons, task2);

        var allTasks = CompletableFuture.allOf(hogwartsTask, beauxbatonsTask);
        allTasks.join();

        // Обработка результатов всех заданий и определение победителя
        var hogwartsPoints = hogwarts.getTotalPoints();
        var beauxbatonsPoints = beauxbatons.getTotalPoints();

        log.info("Результаты");
        showTeamResult(hogwarts, hogwartsPoints);
        showTeamResult(beauxbatons, beauxbatonsPoints);

        if (hogwartsPoints > beauxbatonsPoints || hogwartsPoints < beauxbatonsPoints) {
            var winner = hogwartsPoints > beauxbatonsPoints ? hogwarts : beauxbatons;
            log.info("Победитель - {}", winner.name());
        } else {
            log.info("Ничья. У команд одинаковое число очков");
        }
    }

    private static void showTeamResult(School school, int points) {
        log.info("{} - {} очков", school.name(), points);
    }
}
