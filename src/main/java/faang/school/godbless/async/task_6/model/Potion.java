package faang.school.godbless.async.task_6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Slf4j
@AllArgsConstructor
@Getter
public class Potion {
    private static final long SLEEPING_TIME = 5000;
    private final String name;
    private final int requiredIngredients;

    public CompletableFuture<Integer> gatherIngredients(Potion potion, Executor pool) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("начался сбор ингридиентов для зелья " + potion.getName());
            try {
                Thread.sleep(SLEEPING_TIME);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("сбор ингридиентов для зелья " + potion.getName() + " закончен");
            return requiredIngredients;
            }, pool);
    }
}