package faang.school.godbless.BJS224341;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad tamagotchi1 = new TamagotchiVlad("Vlados");
        TamagotchiVlad tamagotchi2 = new TamagotchiVlad("Vladimir");
        TamagotchiVlad tamagotchi3 = new TamagotchiVlad("Vladislav");

        controller.addTamagotchi(tamagotchi1);
        controller.addTamagotchi(tamagotchi2);
        controller.addTamagotchi(tamagotchi3);

        Thread feedThread = new Thread(controller::feedAll);
        Thread playThread = new Thread(controller::playAll);
        Thread cleanThread = new Thread(controller::cleanAll);
        Thread sleepThread = new Thread(controller::sleepAll);

        feedThread.start();
        playThread.start();
        cleanThread.start();
        sleepThread.start();

        try {
            feedThread.join();
            playThread.join();
            cleanThread.join();
            sleepThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
