package mod1sp3.tamagotchiVlad;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        VladController vladController = new VladController();

        TamagotchiVlad firstVlad = new TamagotchiVlad();
        TamagotchiVlad secondVlad = new TamagotchiVlad();

        vladController.addNewTamogotchi(firstVlad);
        vladController.addNewTamogotchi(secondVlad);

        firstVlad.updateStatus();
        System.out.println();
        secondVlad.updateStatus();

        Thread firstThread = new Thread(vladController::playAll);
        Thread secondThread = new Thread(vladController::cleanAll);
        Thread thirdThread = new Thread(vladController::feedAll);
        Thread fourthThread = new Thread(vladController::sleepAll);

        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();
        fourthThread.join();

        firstVlad.updateStatus();
        System.out.println();
        secondVlad.updateStatus();
    }
}
