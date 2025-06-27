package school.faang.walmart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@AllArgsConstructor
public class CashierThread extends Thread{
    private Integer cashierId;
    private List<Item> customerItems;

    @Override
    public void run() {
        Integer totalPrice = 0;
        System.out.println(cashierId);
        System.out.println("currentThread().getName() = " + currentThread().getName());
        for (Item customerItem : customerItems) {
            System.out.println(customerItem + "currentThread().getName() = " + currentThread().getName());
            totalPrice += customerItem.getPrice();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Всего товаров " + customerItems.size() + " на общую сумму " + totalPrice);
    }
}
