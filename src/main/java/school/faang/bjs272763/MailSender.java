package school.faang.bjs272763;

public class MailSender {

    public static void main(String[] args) {

        int emailsPerThread = 200;
        int threadCount = 5;

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
            }
        }
        System.out.println("Все письма отправлены");
    }
}
