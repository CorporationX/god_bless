package downloading_alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> listPotion = new ArrayList<>();
        listPotion.add(new Potion("love potion", 5));
        listPotion.add(new Potion("Oblivion", 7));
        listPotion.add(new Potion("Negotiable", 15));


        AtomicInteger finalAmount = new AtomicInteger();
        List<CompletableFuture<Void>> completableFutureList = listPotion.stream()
                .map(potion -> CompletableFuture.runAsync(() -> finalAmount.addAndGet(potion.gatherIngredients()))).toList();

        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[completableFutureList.size()])).join();
        System.out.println(finalAmount.get());
    }
}