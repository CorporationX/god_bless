package school.faang.improve_alchemy_BJS2_38674;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public int gatherIngredients() {
        long toSecond = 1000;
        try {
            Thread.sleep(requiredIngredients * toSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return requiredIngredients;
    }
}