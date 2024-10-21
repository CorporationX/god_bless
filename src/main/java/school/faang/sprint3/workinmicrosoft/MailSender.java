package school.faang.sprint3.workinmicrosoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMassages = 1000;
        int threadCount = 5;
        int batchSize = totalMassages / threadCount;

        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Все письмо отправлены");
    }
}
