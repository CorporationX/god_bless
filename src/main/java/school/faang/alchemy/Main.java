package school.faang.alchemy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 10),
                new Potion("Stamina Potion", 4)
        );

        var futureIngredients = Potion.gatherAllIngredients(potions);
        AtomicInteger total = new AtomicInteger(0);
        futureIngredients.forEach(future -> total.addAndGet(future.join()));
        int result = total.get();
        System.out.println("Total ingredients gathered: " + result);
    }
}
