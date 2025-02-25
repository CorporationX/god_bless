package bjs262450;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = new ArrayList<>(initializePotionList());
        Potion potion = new Potion();
        AtomicInteger ingredientsAtomicNumber = potion.calculateIngredients(potions);
        int result = ingredientsAtomicNumber.get();
        log.info("Общее количество собранных ингредиентов: {}", result);
    }

    private static List<Potion> initializePotionList() {
        return List.of(
                new Potion("Healing Potion", 5),
                new Potion("Mana Potion", 3),
                new Potion("Stamina Potion", 4)
        );
    }
}
