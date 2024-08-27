package faang.school.godbless.alhimiya;

import java.util.concurrent.ThreadLocalRandom;

public class PotionService {

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1000L, 3000L));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted");
        }
        return potion.requiredIngredients();
    }
}
