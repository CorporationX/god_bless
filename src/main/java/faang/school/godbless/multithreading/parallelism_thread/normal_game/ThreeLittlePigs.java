package faang.school.godbless.multithreading.parallelism_thread.normal_game;

import java.util.ArrayList;
import java.util.List;

public class ThreeLittlePigs {

    public static void main(String[] args) {

        List<Thread> threadList = new ArrayList<>();
        List<PigThread> pigThreads = new ArrayList<>();
        pigThreads.add(new Pig1Thread("Nif-nif", MaterialEnum.BRICK));
        pigThreads.add(new Pig2Thread("Naf-naf", MaterialEnum.STICK));
        pigThreads.add(new Pig3Thread("Nuf-Nuf", MaterialEnum.STRAW));

        pigThreads.forEach(pig -> {
            pig.start();
            threadList.add(pig);
        });

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("игра завершена!");

    }
}
