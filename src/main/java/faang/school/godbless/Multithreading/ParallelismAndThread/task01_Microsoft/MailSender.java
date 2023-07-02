package faang.school.godbless.Multithreading.ParallelismAndThread.task01_Microsoft;

public class MailSender {
    private static final int threadCount = 5;
    private static final int packSize = 200;

    public static void main(String[] args) {
        try {
            for (int i = 0; i < threadCount; i++) {
                int start = i * packSize;
                int end = start + packSize;
                Thread thread = new Thread(new SenderRunnable(start, end));
                thread.start();
                thread.join();
            }
        } catch (InterruptedException inter) {
            System.out.println("Ошибка запуска потока");
        }
    }
}
