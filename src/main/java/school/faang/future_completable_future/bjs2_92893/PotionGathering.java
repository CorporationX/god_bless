package school.faang.future_completable_future.bjs2_92893;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static school.utils.Utils.runWithThreadErrorHandling;
import static school.utils.Utils.shutdownAndAwaitTermination;

@Slf4j
public class PotionGathering {
    private static final int NUMBER_OF_THREADS = 10;
    private static final int RANDOM_UPPER_BOUND = 5000;
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static void main(String[] args) {

        List<Potion> potions = List.of(
                new Potion("Лечебное зелье", 5),
                new Potion("Большое лечебное зелье", 8),
                new Potion("Зелье маны", 4),
                new Potion("Большое зелье маны", 7),
                new Potion("Зелье силы", 6),
                new Potion("Зелье ловкости", 5),
                new Potion("Зелье интеллекта", 5),
                new Potion("Зелье выносливости", 6),
                new Potion("Зелье невидимости", 9),
                new Potion("Зелье огнестойкости", 6),
                new Potion("Зелье морозостойкости", 6),
                new Potion("Зелье спешки", 7),
                new Potion("Зелье каменной кожи", 8),
                new Potion("Зелье ядовитого клинка", 7),
                new Potion("Зелье ночного зрения", 5),
                new Potion("Зелье удачи", 10),
                new Potion("Зелье очищения", 6),
                new Potion("Зелье регенерации", 9),
                new Potion("Зелье водного дыхания", 7),
                new Potion("Зелье сопротивления магии", 11)
        );

        List<CompletableFuture<Integer>> tasks = potions.stream()
                .filter(Objects::nonNull)
                .map(PotionGathering::gatherIngredients)
                .toList();

        CompletableFuture<Void> inProgressTasks = CompletableFuture.allOf(
                tasks.toArray(new CompletableFuture[0])
        );

        CompletableFuture
                .allOf(inProgressTasks)
                .thenRun(() -> {
                    shutdownAndAwaitTermination(EXECUTOR_SERVICE);
                    int totalAmountOfIngredients = tasks.stream()
                            .map(completableFuture -> {
                                Optional<Integer> res = runWithThreadErrorHandling(() -> completableFuture.get());
                                return res.orElse(0);
                            })
                            .reduce(Integer::sum)
                            .get();
                    log.info("Oбщее количество собранных ингредиентов: {}", totalAmountOfIngredients);
                });
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        return CompletableFuture.supplyAsync(() -> {
            runWithThreadErrorHandling(() -> Thread.sleep(RANDOM_UPPER_BOUND));
            return potion.requiredIngredients();
        }, EXECUTOR_SERVICE).exceptionally(err -> {
            log.info("Задача не выполнена" + err.getMessage());
            return 0;
        });
    }
}