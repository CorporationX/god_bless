package school.faang.Sprints.Multithreading_Async.downloading_alchemy;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PotionService {

    public static void gatherAllIngredients(List<Potion> potions){
        ExecutorService executor = Executors.newFixedThreadPool(3);

    }

    private static int gatherIngredients(Potion potion){
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return potion.getRequiredIngredients();
    }
}
