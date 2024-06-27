package faang.school.godbless.BJS2_14203;

import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class PotionMaker {
    public static void main(String[] args) {
        PotionMaker potionMaker = new PotionMaker();
        Map<String, Integer> paralysisDamageHealthIngredients;
        Map<String, Integer> ravageMagickaIngredients;
        Map<String, Integer> cureDiseaseIngredients;
        paralysisDamageHealthIngredients = Map.of("Canis Root", 2, "Imp Stool", 10, "River Betty", 5);
        ravageMagickaIngredients = Map.of("Orange Dartwing", 15, "Red Mountain Flower", 16);
        cureDiseaseIngredients = Map.of("Vampire Dust", 8, "Charred Skeever Hide", 27);
        Potion paralysisDamageHealth = new Potion("Paralysis and Damage Health", paralysisDamageHealthIngredients);
        Potion ravageMagicka = new Potion("Ravage Magicka", ravageMagickaIngredients);
        Potion cureDisease = new Potion("Cure Disease", cureDiseaseIngredients);
        List<Potion> potions = Arrays.asList(paralysisDamageHealth, ravageMagicka, cureDisease);
        List<String> ingredientsFuture = potions.stream().map(potion -> {
            CompletableFuture<String> str = CompletableFuture.supplyAsync(() -> potionMaker.gatherIngredients(potion));
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(str.get());
                sb.insert(0, potion.getName() + " consists of: ");
            } catch (InterruptedException | ExecutionException e) {
                e.getStackTrace();
            }
            return sb.toString();
        }).toList();
        ingredientsFuture.forEach(System.out::println);
    }

    public String gatherIngredients(Potion potion) {
        int random = ThreadLocalRandom.current().nextInt(3);
        List<String> ingredients = new ArrayList<>();
        try {
            TimeUnit.SECONDS.sleep(random);
            for (Map.Entry<String, Integer> entry : potion.getRequiredIngredients().entrySet()) {
                String string = entry.getKey() + ": " + entry.getValue() + " pcs.";
                ingredients.add(string);
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        return String.join(", ", ingredients);
    }
}
