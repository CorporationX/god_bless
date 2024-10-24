package school.faang.carry;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Item blackKingBar = new Item("Black King Bar", 120, 1200);
        Item ironBranch = new Item("Iron Branch", 1, 50);
        Item morbidMask = new Item("Morbid Mask", 20, 900);
        Item blinkDagger = new Item("Blink Dagger", 45, 2250);
        Item hyperstone = new Item("Hyperstone", 65, 2000);

        Player player = new Player("kokin", 4000);
        player.addItemsInChest(List.of(ironBranch, morbidMask));
        CompletableFuture<Void> future1 = player.assembleItem(ironBranch, blinkDagger);
        CompletableFuture<Void> future2 = player.assembleItem(morbidMask, blackKingBar);

        System.out.println("Игрок выдвигается на мид");

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(future1, future2);
        allTasks.join();
    }
}
