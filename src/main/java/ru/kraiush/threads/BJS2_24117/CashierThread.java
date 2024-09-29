package ru.kraiush.threads.BJS2_24117;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CashierThread extends Thread {

    private int cashierId;
    private List<Goods> customerBasket;

    public void run() {
        System.out.println("Thread ID: " + cashierId + " --- Start at: " + new Date());
        process();
        System.out.println("Thread ID: " + cashierId + " --- Ended at: " + new Date());
    }

    private void process() {
//            System.out.println("customerBasket: " + customerBasket);
        customerBasket.stream()
                .map(e -> {
                    try {
                        Thread.sleep(500 * e.getAmount());
                    } catch (InterruptedException ex) {
                        return Optional.empty();
                    }
                    return e;
                }).collect(Collectors.toList());
    }
}
