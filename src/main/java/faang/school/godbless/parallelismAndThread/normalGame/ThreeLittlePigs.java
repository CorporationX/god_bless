package faang.school.godbless.parallelismAndThread.normalGame;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<PigThread> threadList = List.of(
                new Pig1Thread(),
                new Pig2Thread(),
                new Pig3Thread()
        );

        threadList.forEach(Thread::start);

        threadList.forEach(pigThread -> {
            try {
                pigThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(Thread.currentThread().getName() +  ": игра завершена!");
    }
}
