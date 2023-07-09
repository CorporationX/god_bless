package faang.school.godbless.spring_4.download_alchemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private static final ExecutorService POOL = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Potion> potions = new ArrayList<>() {{
            add(new Potion("Marry friday", 5));
            add(new Potion("Super attractive", 7));
            add(new Potion("Against mosquitoes", 4));
        }};

        CompletableFuture<Integer>[] completableFutures = new CompletableFuture[potions.size()];

        for (int i = 0; i < potions.size(); i++) {
            completableFutures[i] = gatherIngredients(potions.get(i));
        }

        POOL.shutdown();

        CompletableFuture.allOf(completableFutures);

        int num = Arrays.stream(completableFutures).map(integerCompletableFuture -> {
            try {
                return integerCompletableFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).mapToInt(Integer::intValue).sum();

        System.out.println(num);
    }

    private static CompletableFuture<Integer> gatherIngredients(Potion potion) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ignored) {

        }

        return CompletableFuture.supplyAsync(potion::getRequiredIngredients, POOL);
    }
}
