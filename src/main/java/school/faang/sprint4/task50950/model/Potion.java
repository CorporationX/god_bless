package school.faang.sprint4.task50950.model;

import lombok.Getter;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Potion {
    private final int capacity;
    private final String name;
    private final AtomicInteger requiredIngredients = new AtomicInteger();

    public Potion(String name, int requiredIngredients)
    {
        this.name = name;
        this.requiredIngredients.set(requiredIngredients);
        this.capacity = requiredIngredients;
    }

    public int getRequiredIngredients()
    {
        return requiredIngredients.get();
    }

    public int decrementAndGetRequiredIngredients()
    {
        return requiredIngredients.decrementAndGet();
    }




}
