package faang.school.godbless.spring_4.queue_at_walmart;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List[][] customers = new List[][]{{List.of("q", "e", "r"), List.of("j", "k", "s"), List.of("v", "m", "d")}
                , {List.of("t", "i", "p"), List.of("l", "g", "u"), List.of("x", "v", "a")}
                , {List.of("h", "f", "b"), List.of("e", "z", "q"), List.of("w", "c", "j")}};

        CashierThread[] cashiers = new CashierThread[(int) Math.pow(customers.length, 2)];
        int k = 0;
        for (int i = 0; i < customers.length; i++) {
            for (int j = 0; j < customers.length; j++) {
                cashiers[k++] = new CashierThread(k, customers[i][j]);
            }
        }

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i].start();
        }

        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i].join();
        }
    }
}
