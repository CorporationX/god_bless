package faang.school.godbless.BJS2_25230;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
                new Potion("Невидимость", 10),
                new Potion("Сила", 6),
                new Potion("Алгоритмы", 12)
        );

        potions.forEach(Potion::gatherIngredients);
        System.out.println("Зелья сварены");
    }
}
