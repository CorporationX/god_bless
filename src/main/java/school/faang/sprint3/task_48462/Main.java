package school.faang.sprint3.task_48462;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new SenderRunnable(1, 200));
        Thread thread2 = new Thread(new SenderRunnable(200, 400));
        Thread thread3 = new Thread(new SenderRunnable(400, 600));
        Thread thread4 = new Thread(new SenderRunnable(600, 800));
        Thread thread5 = new Thread(new SenderRunnable(800, 1000));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
