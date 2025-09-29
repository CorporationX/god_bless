package school.faang.bjs294920;

import java.util.List;

public class PotionGathering {
    public static void main(String[] args) {
        List<Potion> potions = List.of(
            new Potion("Healing Potion", 5),
            new Potion("Mana Potion", 3),
            new Potion("Stamina Potion", 4)
        );

        // Асинхронный сбор ингредиентов
        gatherAllIngredients(potions);
    }

    private static int gatherAllIngredients(List<Potion> potions) {
        potions.stream().forEach(potion -> {
            new Thread(() -> {
                System.out.println("Gathering ingredients for " + potion.getName() + ": " + potion.getIngridients());
                try {
                    Thread.sleep(1000); // Simulate ingredient gathering time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished gathering ingredients for " + potion.getName());
            }).start();
        });

//        .forEach(potion -> {
//            new Thread(() -> {
//                System.out.println("Gathering ingredients for " + potion.getName() + ": " + potion.getIngridients());
//                try {
//                    Thread.sleep(1000); // Simulate ingredient gathering time
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Finished gathering ingredients for " + potion.getName());
//            }).start();
//        });
    }
}

