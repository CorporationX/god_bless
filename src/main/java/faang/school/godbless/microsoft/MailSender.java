package faang.school.godbless.microsoft;

public class MailSender {

    private static final int TWO_HUNDRED = 200;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            SenderRunnable sender = new SenderRunnable(i * TWO_HUNDRED + 1,
                    i * TWO_HUNDRED + TWO_HUNDRED);
            Thread thread = new Thread(sender);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread " + i + " finished");
        }
        System.out.println("Fin all");
    }
}
