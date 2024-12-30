package school.faang.task_51065;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Potion {
    private final String name;
    private final int requiredIngredients;

    public int gatherIngredients() {
        try {
            System.out.println("Collecting ingredients for the potion" + name);
            Thread.sleep(requiredIngredients * 1000L);
            return requiredIngredients;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Произошло прерываение потока ", e);
        }
    }
}
