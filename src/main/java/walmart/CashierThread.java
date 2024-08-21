package walmart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class CashierThread extends Thread {
    private final int cashierId;
    private final List<Item> items;
    private int cacheBank;

    @Override
    public void run() {
        items.forEach(item -> {
            updateBank(item.getPrice());
            System.out.printf("%s purchased on cash box №%d%n", item.getName(), cashierId);
        });
    }

    private void updateBank(int price) {
        cacheBank += price;
    }
}
