import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        List<List<Integer>> customers = List.of(List.of(1,3,4,5), List.of(40,50), List.of(600,700,800));
        List<Thread> cashiers = new ArrayList<>();
        for(int i=0; i<customers.size(); i++){
            cashiers.add(new Thread(new CashierThread(i, customers.get(i))));
        }
        for (Thread cashier: cashiers) {
            cashier.start();
            cashier.join();
        }

    }
}
