package faang.school.godbless.walmartqueue;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CashierThread extends Thread {

    private long cashierId;
    private Product[] customerItems;

    @Override
    public void run() {
        for (Product customerItem : customerItems) {
            System.out.println(String.format("Product \"%s\" was handled", customerItem.getName()));
        }
    }
}
