package school.faang.factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            numbers.add(random.nextInt(5000));
        }
        List<CompletableFuture<BigInteger>> list = Factorial.calculate(numbers);

        AtomicInteger atom = new AtomicInteger(0);
        for (int i = 0; i < list.size(); i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println(numbers.get(index) + "! = " + list.get(index).get());
                    atom.incrementAndGet();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        System.out.println(numbers);
    }
}