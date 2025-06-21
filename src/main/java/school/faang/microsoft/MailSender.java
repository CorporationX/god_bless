package school.faang.microsoft;

public class MailSender {
    private static final int ALL_EMAIL = 1000;
    private static final int COUNT_FLOW = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[COUNT_FLOW];
        int emailOneFlow = ALL_EMAIL / COUNT_FLOW;
        for (int i = 0; i < COUNT_FLOW; i++) {
            int first = i * emailOneFlow;
            int last = (i + 1) * emailOneFlow;
            threads[i] = new Thread(new SenderRunnable(first, last));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Успех");
    }
}
