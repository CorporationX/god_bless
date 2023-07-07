package faang.school.godbless.asyncAndFuture.alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

    public int gatherIngredients() {
        System.out.println("Начало сбора ингредиентов для зелья: " + name);
        try {
            Thread.sleep(requiredIngredients * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Окончание сбора ингредиентов для зелья: " + name);
        return requiredIngredients;
    }
}
