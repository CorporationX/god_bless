package school.faang.alhimia;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Зелье1", 3),
                new Potion("Зелье2", 2),
                new Potion("Зелье3", 6),
                new Potion("Зелье4", 1),
                new Potion("Зелье5", 2),
                new Potion("Зелье6", 4)
        );

        PotionService potionService = new PotionService();
        potionService.fetchIngredientsAsync(potions);
        potionService.printTotalIngredients();
    }
}