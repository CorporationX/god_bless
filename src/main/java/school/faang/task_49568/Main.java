package school.faang.task_49568;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static final int VLAD_COUNT = 10;

    private static final VladController controller = new VladController();

    public static void main(String[] args) {
        IntStream.rangeClosed(1, VLAD_COUNT)
                .forEach(i -> controller.addVlad(new TamagotchiVlad("Влад-" + i)));

        controller.removeVlad(new TamagotchiVlad("Влад-10"));

        Stream.of(
                new Thread(controller::feedAll),
                new Thread(controller::playAll),
                new Thread(controller::cleanAll),
                new Thread(controller::sleepAll)
        ).forEach(Thread::start);
    }

}
