package faang.school.godbless.microsoft;

public class MailSender {

    private static final int TWO_HUNDRED = 200;
    private static final int THREAD_COUNT = 5;

    private static final Thread[] THREADS = new Thread[THREAD_COUNT];

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            SenderRunnable sender = new SenderRunnable(i * TWO_HUNDRED + 1,
                    i * TWO_HUNDRED + TWO_HUNDRED);
            THREADS[i] = new Thread(sender);
            THREADS[i].start();
        }

        for (Thread thread : THREADS) {
            thread.join();
            System.out.println(thread.getName() + " finished ");
        }

        System.out.println("Fin all");
    }
}
