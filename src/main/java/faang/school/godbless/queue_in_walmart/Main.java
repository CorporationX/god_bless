package faang.school.godbless.queue_in_walmart;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> customers = initialize();
        for (int i =0; i < customers.size(); i++) {
            CashierThread cashierThread = new CashierThread(i, customers.get(i));
            cashierThread.start();
        }
    }

    public static List<List<String>> initialize() {
        return List.of(
                List.of("test1-1", "test2-1", "test3-1"),
                List.of("test1-2", "test2-2", "test3-2"),
                List.of("test1-3", "test2-3", "test3-3"),
                List.of("test1-4", "test2-4", "test3-4"),
                List.of("test1-5", "test2-5", "test3-5"),
                List.of("test1-6", "test2-6", "test3-6"),
                List.of("test1-7", "test2-7", "test3-7")
        );
    }
}