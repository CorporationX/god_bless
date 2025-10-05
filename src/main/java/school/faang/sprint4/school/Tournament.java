package school.faang.sprint4.school;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class Tournament {
    private static final Integer TIME_AWAIT_SECONDS = 5;
    private final ExecutorService executorService = Executors.newFixedThreadPool(8);
    private final List<School> schools;

    public CompletableFuture<School> startTask(School school, Task task) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("%s start task \n", Thread.currentThread().getName());
            school.doTask(task);
            return school;
        }, executorService);
    }

    public School getWinner() {
        return schools.stream()
                .reduce((result, school) -> result.getTotalPoints() > school.getTotalPoints() ? result : school)
                .orElseThrow(() -> new RuntimeException("Winner getting error"));
    }

    public void printResults() {
        schools.forEach(school -> System.out.printf("%s = %d\n", school.getName(), school.getTotalPoints()));
    }


    public void end() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIME_AWAIT_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("Потоки завершили работу");
            } else {
                System.out.println("Ошибка ожидания окончания работы потоков");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Прерывание ожидания окончания работы потоков");
            Thread.currentThread().interrupt();
        }
    }
}
