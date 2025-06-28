package school.faang.bjs2_82817;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        School vikings = new School("Vikings", Arrays.asList(
                new Student("Nicholas", 3, 0),
                new Student("Kevin", 3, 0)
        ));
        School noobs = new School("Noobs", Arrays.asList(
                new Student("John", 3, 0),
                new Student("James", 2, 0)
        ));

        Task quest1 = new Task("пройти дс 2 без смертей", 3, 100);
        Task quest2 = new Task("пройти дс 1 без смертей", 2, 50);

        Tournament tournament = new Tournament();

        CompletableFuture<School> result1 = tournament.startTask(vikings, quest1);
        CompletableFuture<School> result2 = tournament.startTask(noobs, quest2);

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(result1, result2);

        try {
            allTasks.join();
        } catch (CompletionException e) {
            Throwable cause = e.getCause();
            log.error("произошла ошибка во время выполнения заданий: {}", cause.getMessage(), cause);
            throw new RuntimeException(cause);

        }

        List<School> schools = List.of(result1.join(), result2.join());
        School winner = schools.stream()
                .max(Comparator.comparingInt(School::getTotalPoints))
                .orElse(null);

        log.info("победила школа {} набрав {} очков", winner.getName(), winner.getTotalPoints());
    }
}
