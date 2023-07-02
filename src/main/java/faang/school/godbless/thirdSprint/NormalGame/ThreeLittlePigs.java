package faang.school.godbless.thirdSprint.NormalGame;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<PigThread> threads = List.of(new Pig1Thread(), new Pig2Thread(), new Pig3Thread());
        threads.forEach(PigThread::start);
        for (PigThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Игра завершена!");
    }
}
