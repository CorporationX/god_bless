package faang.school.godbless.microsoft;

public class MailSender {

    private static final int TWO_HUNDRED = 200;
    private static final int THREAD_COUNT = 5;

    static Thread[] threads = new Thread[THREAD_COUNT];

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < THREAD_COUNT; i++) {
            SenderRunnable sender = new SenderRunnable(i * TWO_HUNDRED + 1,
                    i * TWO_HUNDRED + TWO_HUNDRED);
            threads[i] = new Thread(sender);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
            System.out.println(thread.getName() + " finished ");
        }

        System.out.println("Fin all");
    }
}
