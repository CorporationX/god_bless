package faang.school.godbless.BJS214285;

import java.util.concurrent.atomic.AtomicInteger;

public class ResultIngredientsCounter {
    private final AtomicInteger sumOfAllIngredients;

    public ResultIngredientsCounter(){
        this.sumOfAllIngredients = new AtomicInteger(0);
    }

    public int add(final int num) {
        return sumOfAllIngredients.addAndGet(num);
    }

    public int getSumOfAllIngredients(){
        return sumOfAllIngredients.get();
    }
}
