package faang.school.godbless.DownloadAlchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger numberOfIngredients = new AtomicInteger();
    public static void main(String[] args) {

        List<Potion> potions = new ArrayList<>(List.of(
                new Potion("Ageing Potion", 7),
                new Potion("Kissing Concoction", 5),
                new Potion("Noxious Poison", 9),
                new Potion("Beautification Potion", 4),
                new Potion("Fire Protection Potion", 10)));

        ExecutorService executor = Executors.newFixedThreadPool(potions.size());
        // почему-то берет только 3 потока из 5
        List<CompletableFuture<Void>> future = potions.stream()
                .map(potion -> CompletableFuture.supplyAsync(() -> gatherIngredients(potion))
                        .thenAccept(numberOfIngredients::addAndGet))
                .toList();

        CompletableFuture.allOf(future.toArray(new CompletableFuture[0])).join();
        executor.shutdown();
        System.out.println("Всего собрано ингридиентов: " + numberOfIngredients);
    }

    private static int gatherIngredients(Potion potion) {
        try {
            System.out.println("Собираем ингредиенты для " + potion.getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Iнгредиенты для " + potion.getName() + " собраны в потоке " + Thread.currentThread().getName());
        return potion.getRequiredIngredients();
    }
}
