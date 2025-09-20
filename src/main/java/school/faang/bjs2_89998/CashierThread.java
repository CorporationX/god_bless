package school.faang.bjs2_89998;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private List<Item> customerItems;

    @Override
    public void run() {
        for (Item item : customerItems) {
            System.out.printf("%s %d руб%n", item.getName(), item.getPrice());
        }
        int totalSum = customerItems.stream()
                .map(Item::getPrice)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.printf("Итого с вас %d руб за %d товаров.%n", totalSum, customerItems.size());
    }
}
