package faang.school.godbless.SkyNet;

public class SkyNet {
    public static void main(String[] args) {
        Robot target1 = new Robot(1);
        Robot target2 = new Robot(2);
        Robot target3 = new Robot(3);

        Thread thread1 = new Thread(target1);
        Thread thread2 = new Thread(target1);
        Thread thread3 = new Thread(target2);
        Thread thread4 = new Thread(target3);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Все потоки выполнены");
    }
}
