package school.faang.task_61474;

import lombok.SneakyThrows;

public class TamagotchiSimulation {
    @SneakyThrows
    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Влад-1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Влад-2");

        controller.addVlad(vlad1);
        controller.addVlad(vlad2);

        Thread feedThread = new Thread(controller::feedAll);
        Thread playThread = new Thread(controller::playAll);
        Thread cleanThread = new Thread(controller::cleanAll);
        final Thread sleepThread = new Thread(controller::sleepAll);

        feedThread.start();
        playThread.start();
        cleanThread.start();
        sleepThread.start();

        feedThread.join();
        playThread.join();
        cleanThread.join();
        sleepThread.join();
    }
}
