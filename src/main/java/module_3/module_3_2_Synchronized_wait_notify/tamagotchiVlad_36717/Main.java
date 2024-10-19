package module_3.module_3_2_Synchronized_wait_notify.tamagotchiVlad_36717;

public class Main {
    public static void main(String[] args) {
        VladController vladController = new VladController();
        final int countVlads = 5;

        for (int i = 0; i < countVlads; i++) {
            TamagochiVlad tamagochiVlad = new TamagochiVlad("Влад " + i);
            vladController.addVlad(tamagochiVlad);
        }

        Thread feedThread = new Thread(vladController::feedAll);
        Thread playThread = new Thread(vladController::playAll);
        Thread cleanThread = new Thread(vladController::cleanAll);
        Thread sleepThread = new Thread(vladController::sleepAll);

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
            throw new RuntimeException(e);
        }
        System.out.println("Программа завершеет свою работу...");
    }
}
