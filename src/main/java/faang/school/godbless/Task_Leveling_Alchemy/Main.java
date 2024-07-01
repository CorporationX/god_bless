package faang.school.godbless.Task_Leveling_Alchemy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static final List<Potion> potions = new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PotionMaker.gatherAllIngredients(potions);
    }

    static {
        potions.add(new Potion("pepsi", 2));
        potions.add(new Potion("sprite", 3));
        potions.add(new Potion("cola", 3));
    }
}
