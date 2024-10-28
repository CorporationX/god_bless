package school.faang.alchemy;

import java.util.concurrent.atomic.AtomicInteger;

public record Potion(String name,
                     int requiredIngredients) {
    public static final AtomicInteger totalIngredients = new AtomicInteger(0);

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return potion.requiredIngredients;
    }
}