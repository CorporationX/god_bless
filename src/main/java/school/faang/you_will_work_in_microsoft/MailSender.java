package school.faang.you_will_work_in_microsoft;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        int batchSize = 1000 / 5;
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
            System.out.println("Поток № " + i + " и запущен из основного потока: " + Thread.currentThread().getName());
        }
    }
}
