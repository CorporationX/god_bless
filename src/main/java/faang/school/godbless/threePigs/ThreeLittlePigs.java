package faang.school.godbless.threePigs;

import java.util.List;

public class ThreeLittlePigs {
    private static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        PigThread pig1 = new Pig1Thread("Ниф-Ниф", 0);
        PigThread pig2 = new Pig2Thread("Нaф-Нaф", 1);
        PigThread pig3 = new Pig3Thread("Нyф-Нyф", 2);

        List<PigThread> pigThreads = List.of(pig1, pig2, pig3);

        pigThreads.forEach(PigThread::start);

        pigThreads.forEach(pigThread -> {
            try {
                pigThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(ANSI_RED + "GAME OVER!!!" + ANSI_RESET);
    }
}
