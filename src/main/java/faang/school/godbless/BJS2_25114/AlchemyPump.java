package faang.school.godbless.BJS2_25114;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class AlchemyPump {
    public static void main(String[] args) {
        Potion helthPotion = new Potion("Health", 3);
        Potion powerPotion = new Potion("Power", 4);
        Potion magePotion = new Potion("Mage", 10);

        List<CompletableFuture<Integer>> resultFutures = Stream.of(helthPotion, powerPotion, magePotion)
                .map(AlchemyPump::gatherIngredients)
                .map(CompletableFuture::supplyAsync)
                .toList();

        CompletableFuture<Integer>[] resultFuturesArray = resultFutures.toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(resultFuturesArray)
                .thenRun(() -> {
                    int sum = Arrays.stream(resultFuturesArray)
                            .mapToInt(future -> {
                                try {
                                    return future.get();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException("Interrupt error");
                                } catch (ExecutionException e) {
                                    throw new RuntimeException("Get error");
                                }
                            })
                            .sum();
                    System.out.println("Sum: " + sum);
                }).join();
    }

    private static Supplier<Integer> gatherIngredients(Potion potion) {
        return () -> {
            try {
                Thread.sleep(potion.getRequiredIngredients() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException("Sleep error");
            }
            return potion.getRequiredIngredients();
        };
    }
}
