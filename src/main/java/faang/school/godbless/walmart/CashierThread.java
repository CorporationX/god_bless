package faang.school.godbless.walmart;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashierThread extends Thread {
    private String cashierId;
    private String[] customerItems;

    @Override
    public void run() {
        for (String items : customerItems) {
            System.out.println(getCashierId() + " пробил " + items);
        }
        System.out.println("Кассир " + cashierId + " пробил " + customerItems.length + " товаров");
    }
}
