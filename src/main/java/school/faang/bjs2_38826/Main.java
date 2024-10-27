package school.faang.bjs2_38826;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>();

        Potion blackBlood = new Potion("Black Blood", 7);
        Potion popsMoldAntidote = new Potion("Pops' mold antidote", 6);
        Potion swallow = new Potion("Swallow", 7);
        Potion tawnyOwl = new Potion("Tawny Owl", 4);

        potions.add(blackBlood);
        potions.add(popsMoldAntidote);
        potions.add(swallow);
        potions.add(tawnyOwl);

        int total = IngredientsCollector.totalIngredients(IngredientsCollector.gatherIngredients(potions));

        System.out.println("Total amount of ingredients collected: " + total);
    }
}
