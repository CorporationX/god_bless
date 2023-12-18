package faang.school.godbless.multi_paral.task8normal;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        PigThread[] pigThreads = {new Pig1Thread(), new Pig2Thread(), new Pig3Thread()};

        Arrays.stream(pigThreads).forEach((x) -> {
            try {
                x.start();
                x.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("--------------------------------------");
        System.out.println("Игра завершена!");

        PigThread pigWin = Arrays.stream(pigThreads).max(Comparator.comparing(PigThread::getMaterial)).orElseThrow();
        System.out.println(pigWin.getPigName() + " выжил и соответственно победил...");
    }
}
