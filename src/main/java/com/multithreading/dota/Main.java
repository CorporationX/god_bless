package com.multithreading.dota;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Item morbidMask = new Item("Morbid mask", 10);
        Item gauntletsOfStrength = new Item("Gauntlets of strength", 5);
        Item bootsOfSpeed = new Item("Boots of speed", 5);

        Item broadsword = new Item("Broadsword", 15);
        Item circlet = new Item("Circlet", 5);
        Item energyBooster = new Item("Energy booster", 10);

        Storage chest = new Storage();
        chest.addItem(morbidMask);
        chest.addItem(gauntletsOfStrength);
        chest.addItem(bootsOfSpeed);

        Storage bench = new Storage();
        bench.addItem(broadsword);
        bench.addItem(circlet);
        bench.addItem(energyBooster);


        SuperItem maskOfMadness = new SuperItem("Mask of madness", morbidMask, broadsword);
        SuperItem bracer = new SuperItem("Bracer", gauntletsOfStrength, circlet);
        SuperItem arcaneBoots = new SuperItem("Arcane boots", bootsOfSpeed, energyBooster);

        List<SuperItem> superItems = Arrays.asList(maskOfMadness, bracer, arcaneBoots);

        Inventory inventory = new Inventory(superItems);

       inventory.getItem(chest.getItems(), maskOfMadness)
               .thenCombine(inventory.getItem(bench.getItems(), maskOfMadness), inventory::combineItems)
                       .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))).join();

        System.out.println(inventory.getItems());
    }
}
