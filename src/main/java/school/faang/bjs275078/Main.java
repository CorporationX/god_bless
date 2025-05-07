package school.faang.bjs275078;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        PotionService potionService = new PotionService();
        potionService.gatherAllIngredients(create());
    }


    private static List<Potion> create() {
        Random random = new Random();
        ArrayList<Potion> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Potion potion = new Potion("Potion" + random.nextInt(1, 100),
                    random.nextInt(1, 5));
            result.add(potion);
        }
        return result;
    }
}
