package school.faang.task_61474;

import lombok.SneakyThrows;

import java.util.List;

public class TamagotchiSimulation {
    @SneakyThrows
    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Влад-1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Влад-2");

        controller.addVlad(vlad1);
        controller.addVlad(vlad2);

        List<Thread> threads = List.of(
                new Thread(controller::feedAll),
                new Thread(controller::playAll),
                new Thread(controller::cleanAll),
                new Thread(controller::sleepAll)
        );

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
