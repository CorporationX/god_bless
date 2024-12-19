package school.faang.sprint3.task_48462;

public class Main {
    public static void main(String[] args) {
        final Thread thread1 = new Thread(new SenderRunnable(1, 200));
        final Thread thread2 = new Thread(new SenderRunnable(201, 400));
        final Thread thread3 = new Thread(new SenderRunnable(401, 600));
        final Thread thread4 = new Thread(new SenderRunnable(601, 800));
        final Thread thread5 = new Thread(new SenderRunnable(801, 1000));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
