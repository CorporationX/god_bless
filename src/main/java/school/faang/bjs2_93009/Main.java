package school.faang.bjs2_93009;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int WAITING_TIME = 2;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<School> schools = List.of(new School("Школа №1", List.of(
                        new Student("Вася", 2000, 15),
                        new Student("Петя", 2002, 17),
                        new Student("Маша", 2001, 16))),
                new School("Школа №2", List.of(
                        new Student("Оля", 2000, 15),
                        new Student("Лена", 2002, 17),
                        new Student("Дима", 2001, 16))),
                new School("Школа №3", List.of(
                        new Student("Катя", 2000, 15),
                        new Student("Дуся", 2002, 17),
                        new Student("Антон", 2001, 16))),
                new School("Школа №4", List.of(
                        new Student("Леонид", 2000, 15),
                        new Student("Цицилия", 2002, 17),
                        new Student("Еремей", 2001, 16)))
        );

        List<Task> tasks = List.of(
                new Task("Математика", 10, 10),
                new Task("Химия", 12, 12),
                new Task("Физика", 15, 15),
                new Task("Русский язык", 18, 18));

        List<CompletableFuture<School>> completableFuturesSchools = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            completableFuturesSchools.add(Tournament.startTask(schools.get(i), tasks.get(i)));
        }

        List<School> schoolsAfterTasks = new ArrayList<>();
        for (CompletableFuture<School> completableFutureSchool : completableFuturesSchools) {
            schoolsAfterTasks.add(completableFutureSchool.get());
        }
        log.info("Все школы закончили свои задания.");
        for (School school : schoolsAfterTasks) {
            log.info("По итогу {} получила {} баллов", school.getName(), school.getTotalPoints());
        }
        Tournament.EXECUTOR.shutdown();
        try {
            if (!Tournament.EXECUTOR.awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                log.error("Не все задачи завершены в указанный период времени.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Поток main не смог должаться окончания, он был прерван.");
        }
    }
}
