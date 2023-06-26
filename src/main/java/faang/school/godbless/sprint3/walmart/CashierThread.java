package faang.school.godbless.sprint3.walmart;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CashierThread extends Thread{
    private int cashierId;
    private int customerItems;

    @Override
    public void run(){
        System.out.println(String.format("Cashier %s: sell off %s", cashierId, customerItems));
    }
}
