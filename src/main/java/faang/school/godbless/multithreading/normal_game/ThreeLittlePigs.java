package faang.school.godbless.multithreading.normal_game;

import java.util.List;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        List<PigThread> pigThreads = List.of(
                new Pig1Thread("Ниф-ниф", "солома"),
                new Pig2Thread("Нуф-нуф", "палки"),
                new Pig3Thread("Наф-наф", "кирпичи")
        );

        pigThreads.forEach(PigThread::start);

        for (PigThread pigThread : pigThreads) {
            pigThread.join();
        }

        System.out.println("Все дома построены");
    }
}
