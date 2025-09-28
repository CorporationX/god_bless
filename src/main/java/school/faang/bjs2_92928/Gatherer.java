package school.faang.bjs2_92928;

public class Gatherer {
    private static final int THREAD_SLEEP_MS = 1000;

    public int gatherIngredients(Potion potion) {
        try {
            Thread.sleep(THREAD_SLEEP_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return potion.getIngredients();
    }
}
