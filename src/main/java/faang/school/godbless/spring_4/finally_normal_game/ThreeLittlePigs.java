package faang.school.godbless.spring_4.finally_normal_game;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread pig1Thread = new Pig1Thread("Nif Nif", "straw");
        Pig2Thread pig2Thread = new Pig2Thread("Naf Naf", "tree");
        Pig3Thread pig3Thread = new Pig3Thread("Nuf Nuf", "stone");
        List<PigThread> pigThreads = List.of(pig1Thread, pig2Thread, pig3Thread);

        pigThreads.forEach(Thread::start);

        pigThreads.forEach(pigThread -> {
            try {
                pigThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Game close!!!");
    }
}
