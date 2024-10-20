package school.faang.queueatwalmart;

import java.util.Random;
import java.util.stream.IntStream;

public class WalmartSimulation {
    public static void main(String[] args) {
        int[][] customers = new int[10][];
        Random random = new Random();

        IntStream.range(0, customers.length).forEach(i -> {
            int itemCount = random.nextInt(10) + 1; // Each customer has between 1 and 10 items
            customers[i] = IntStream.generate(() -> random.nextInt(20) + 1).limit(itemCount).toArray();
        });
    }
}

