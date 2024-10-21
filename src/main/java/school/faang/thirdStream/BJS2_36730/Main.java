package school.faang.thirdStream.BJS2_36730;

import java.util.List;

public class Main {
    private static final int NUMBER_OF_BABYSITTERS = 4;

    public static void main(String[] args) {
        VladController controller = new VladController();

        for (int i = 0; i < NUMBER_OF_BABYSITTERS; i++) {
            controller.addVlad(new TamagotchiVlad("Влад-" + (i + 1)));
        }

        Thread feedThread = new Thread(controller::feedAll);
        Thread playThread = new Thread(controller::playAll);
        Thread cleanThread = new Thread(controller::cleanAll);
        Thread sleepThread = new Thread(controller::sleepAll);

        List<Thread> babysitters = List.of(feedThread, playThread, cleanThread, sleepThread);

        babysitters.forEach(Thread::start);

        for (Thread babysitter : babysitters) {
            try {
                babysitter.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
