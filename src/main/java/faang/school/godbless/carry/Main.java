package faang.school.godbless.carry;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static Random rnd = new Random();
    public static void main(String[] args) {
        Inventory playerInventory = new Inventory();
        Inventory storeInventory = new Inventory();
        for (int i = 0; i < 2; i++) {
            playerInventory.addItem(generateItem());
            storeInventory.addItem(generateItem());
        }
        playerInventory.getItems().forEach(item -> System.out.println(item.getName() + " with power = " + item.getPower()));
        System.out.println("**********");
        playerInventory.getItem().thenCombine(storeInventory.getItem(), playerInventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> playerInventory.addItem(item)));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        playerInventory.getItems().forEach(item -> System.out.println(item.getName() + " with power = " + item.getPower()));
    }

    private static Item generateItem() {
        return new Item(generateName(), rnd.nextInt(100));
    }

    private static String generateName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (rnd.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
