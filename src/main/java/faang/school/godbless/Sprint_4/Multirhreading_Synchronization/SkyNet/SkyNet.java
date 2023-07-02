package faang.school.godbless.Sprint_4.Multirhreading_Synchronization.SkyNet;

public class SkyNet {
    public static void main(String[] args) throws InterruptedException {
        Robot r1 = new Robot(1);
        Robot r2 = new Robot(2);

        Thread thread1 = new Thread(r1::attack);
        Thread thread2 = new Thread(r2::attack);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
