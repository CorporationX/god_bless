package faang.school.godbless.Walmart;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class CashierThread extends Thread{
    private int cashierId;
    private int[] customerItems;
    private int totalCost = 0;
    private int itemsCounter = 0;

    public CashierThread(int cashierId, int[] customerItems) {
        this.cashierId = cashierId;
        this.customerItems = customerItems;
    }

    @Override
    public void run() {
        for (int item : customerItems) {
            Item foundItem = getInfoByItemId(item);
            itemsCounter++;
            totalCost += foundItem.getPrice();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(
                    "Cashier #" + cashierId +":\n" +
                    "item: " + foundItem.getName()  + " is processed, " +
                            "its price is: " + foundItem.getPrice() +
                            "\n-----------------"
            );
        }
    }

    public static Map<Integer, Item> getItemsData() {
        return Map.of(
                1, new Item("Bread", 24),
                2, new Item("Milk", 70),
                3, new Item("Pasta", 50),
                4, new Item("Baton", 34),
                5, new Item("Sausage", 200),
                6, new Item("Cheese", 250),
                7, new Item("Dumplings", 250),
                8, new Item("Tea", 80),
                9, new Item("Coffee", 200),
                10, new Item("Chocolate", 80)
        );
    }

    public static Item getInfoByItemId(int item) {
        return getItemsData().get(item);
    }
}
