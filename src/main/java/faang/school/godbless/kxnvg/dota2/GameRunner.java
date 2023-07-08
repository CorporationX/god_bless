package faang.school.godbless.kxnvg.dota2;

public class GameRunner {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.combineItems(new Item("меч", 12), new Item("кувалда", 8));
    }
}
