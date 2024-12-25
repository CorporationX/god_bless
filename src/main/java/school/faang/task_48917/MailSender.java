package school.faang.task_48917;

public class MailSender {
    public static final int THREADS_QUANTITY = 5;
    public static final int MAILS_QUANTITY = 1000;
    public static final int MAILS_PER_THREAD = MAILS_QUANTITY / THREADS_QUANTITY;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_QUANTITY];

        for (int i = 0; i < THREADS_QUANTITY; i++) {
            int starIndex = MAILS_PER_THREAD * i;
            int endIndex = MAILS_PER_THREAD * (i + 1);
            threads[i] = new Thread(new SenderRunnable(starIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join(1000);
            System.out.printf("Mails from thread %d had sent!\n\n", thread.getId());

        }
        System.out.println("All mails had sent!");
    }
}
