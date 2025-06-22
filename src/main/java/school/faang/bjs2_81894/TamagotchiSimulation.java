package school.faang.bjs2_81894;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class TamagotchiSimulation {
    public static void main(String[] args) {
        List<Thread> threads = getThreads();

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Произошла ошибка", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
    }

    private static List<Thread> getThreads() {
        VladController controller = new VladController();

        TamagotchiVlad vladFirst = new TamagotchiVlad("Влад-I");
        TamagotchiVlad vladSecond = new TamagotchiVlad("Влад-II");

        controller.addTamagotchiVlad(vladFirst);
        controller.addTamagotchiVlad(vladSecond);

        return List.of(
                new Thread(controller::feedAll),
                new Thread(controller::playAll),
                new Thread(controller::cleanAll),
                new Thread(controller::sleepAll)
        );
    }
}
