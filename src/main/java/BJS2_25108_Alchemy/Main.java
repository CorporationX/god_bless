package BJS2_25108_Alchemy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Potion> potions = Arrays.asList(new Potion("Health Potion", 2),
                new Potion("Mana Potion", 3),
                new Potion("Strength Potion", 4),
                new Potion("Speed Potion", 10));

        int sum = 0;
        for (Potion potion : potions) {
            sum += potion.gatherIngredients(potion);
        }
        log.info("Total ingredients needed is : {}", sum);
    }
}
