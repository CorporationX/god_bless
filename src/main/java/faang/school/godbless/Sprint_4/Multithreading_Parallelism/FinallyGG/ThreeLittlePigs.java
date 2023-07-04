package faang.school.godbless.Sprint_4.Multithreading_Parallelism.FinallyGG;

import java.util.ArrayList;
import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>(3);
        threads.add(new Thread(new Pig1Thread()));
        threads.add(new Thread(new Pig2Thread()));
        threads.add(new Thread(new Pig3Thread()));
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
