package school.faang.bjs272763;

public class MailSender {

    public static void main(String[] args) {

        int emailsTotal = 1000;
        int threadCount = 5;
        int emailsPerThread = emailsTotal / threadCount;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int start = i * emailsPerThread;
            int end = start + emailsPerThread;

            SenderRunnable sender = new SenderRunnable(start, end);

            threads[i] = new Thread(sender, "Поток " + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка InterruptedException");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Все письма отправлены");
    }
}
