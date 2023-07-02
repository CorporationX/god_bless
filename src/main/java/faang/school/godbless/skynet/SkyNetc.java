package faang.school.godbless.skynet;

public class SkyNetc {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Robot("Target 1")::attack);
        Thread thread2 = new Thread(new Robot("Target 2")::attack);

        thread1.start();
        thread2.start();
    }
}
