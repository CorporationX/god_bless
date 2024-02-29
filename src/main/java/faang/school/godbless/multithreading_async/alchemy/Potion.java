package faang.school.godbless.multithreading_async.alchemy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Data
@Getter
public class Potion {
    private String name;
    private int requiredIngredients;

    public static CompletableFuture<Integer> gatherIngredients(Potion potion){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Собираю ингредиенты для зелья " + potion.getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Собрали все для зелья " + potion.getName());
            return potion.getRequiredIngredients();
        });
    }
}
