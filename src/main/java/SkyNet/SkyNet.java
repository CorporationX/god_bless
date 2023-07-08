package SkyNet;

public class SkyNet {
    public static void main(String[] args) throws InterruptedException {
        Robot first = new Robot("Human");
        Robot second = new Robot("Human");

        Thread firstThread = new Thread(first::attack);
        Thread secondThread = new Thread(second::attack);

        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();
    }
}
