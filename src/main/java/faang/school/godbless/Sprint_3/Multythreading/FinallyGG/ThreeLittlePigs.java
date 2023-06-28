package faang.school.godbless.Sprint_3.Multythreading.FinallyGG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<String> pigs = Arrays.asList("Ниф-Ниф", "Нуф-Нуф", "Наф-Наф");
        List<Thread> threads = new ArrayList<>(3);
        threads.add(new Thread(new Pig1Thread(pigs.get(0), 0)));
        threads.add(new Thread(new Pig2Thread(pigs.get(1), 1)));
        threads.add(new Thread(new Pig3Thread(pigs.get(2), 2)));
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();

        threads.stream()
                .forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.println("Игра завершена!");
    }
}
