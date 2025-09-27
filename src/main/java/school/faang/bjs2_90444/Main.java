package school.faang.bjs2_90444;

public class Main {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) throws InterruptedException {
        VladController vladController = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Влад-1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Влад-2");

        vladController.addVlad(vlad1);
        vladController.addVlad(vlad2);

        Thread thread1 = new Thread(vladController::feedAll);
        Thread thread2 = new Thread(vladController::playAll);
        Thread thread3 = new Thread(vladController::cleanAll);
        Thread thread4 = new Thread(vladController::sleepAll);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}
