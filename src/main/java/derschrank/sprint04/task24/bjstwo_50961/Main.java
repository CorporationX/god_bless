package derschrank.sprint04.task24.bjstwo_50961;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    private static final int COUNT_OF_STORES = 10;

    public static void main(String[] args) {
        List<Integer> stores = generateStores(COUNT_OF_STORES);

        new ReportGenerator().generateReport(stores);
    }

    private static List<Integer> generateStores(int count) {
        return IntStream.rangeClosed(1, count).boxed().toList();
    }
}
