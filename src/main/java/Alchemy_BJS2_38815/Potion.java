package Alchemy_BJS2_38815;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class Potion {
    private final String name;
    private final int requiredIngredients;

    public int gatherIngredients() {
        try {
            System.out.println("Gathering ingredients for potion: " + getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getRequiredIngredients();
    }
}