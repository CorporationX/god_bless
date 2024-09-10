package ru.kraiush.threads.BJS2_25140;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AppGarryAteTooMuch {

    public static void main(String[] args) {

        Item item1 = new Item(getMiraculousObject(), 90);
        Item item2 = new Item(getItemFromShop(), 9);

        List<Item> listItems = new ArrayList<>();
        Inventory inventory = new Inventory(listItems);

        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println();

        CompletableFuture<List<Item>> listFuture = inventory.addItem(listItems, inventory.combineItems(item1, item2));
        try {
            System.out.println("CompletableFuture<List<Item>>");
            System.out.println(listFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }

    public static String getMiraculousObject() {
        String[] foodTypes = {"the Kladenets sword", "the invisibility cloak", "the wizard's hat", "the wand of a lifesaver", "the ring of omnipotence", "boots runners", "the vessel of eternal life"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }

    public static String getItemFromShop() {
        String[] foodTypes = {"incomparable beauty", "inventive of mind", "nimble feet", "dexterous hands", "grasping fingers", "inexhaustible energy", "a little luck"};
        return foodTypes[new Random().nextInt(foodTypes.length)];
    }
}
