package faang.school.godbless.Sprint_5.Multithreading_Async.Alchemy;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Main {
    public static int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(potion.getName() + " is ready!");
        return potion.getRequiredIngredients();
    }

    public static void main(String[] args) {
        List<Potion> potions = List.of(new Potion("p1", 3), new Potion("p2", 4), new Potion("p3", 5));

        List<CompletableFuture<Integer>> future = potions.stream().map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))).toList();
        CompletableFuture<Void> resultantCF = CompletableFuture.allOf(future.toArray(new CompletableFuture[future.size()]));
        int res = future.stream().map(fi -> {
            try {
                return fi.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).reduce(0, Integer::sum);
        System.out.println(res);
    }
}
