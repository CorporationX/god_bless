package faang.school.godbless.Walmart;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CashierThread extends Thread {
    private int cashierId;
    private List<Product> customerItems;

    @Override
    public void run() {
        int totalCost = 0;
        for (Product product : customerItems) {
            System.out.println(product.getName() + " - at the checkout");
            totalCost += product.getCost();
        }
        System.out.println(customerItems.size() + " products worth " + totalCost  + " were handled by cashierId: " + cashierId);
    }
}
