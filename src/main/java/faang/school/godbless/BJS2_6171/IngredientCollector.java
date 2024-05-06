package faang.school.godbless.BJS2_6171;

public class IngredientCollector {
    public Integer gatherIngredients(Potion potion){
        if (potion == null) {
            throw new NullPointerException("Передана пустая информация о зелье");
        }

        try {
            Thread.sleep(potion.getRequiredIngredients() * 10L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return potion.getRequiredIngredients();
    }
}
