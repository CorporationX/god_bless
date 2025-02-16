package school.faang.workatmicrosoft;

public class App {
    public static final int EMAILS_AMOUNT_PER_THREAD = 200;
    public static final int THREADS_AMOUNT = 5;

    public static void main(String[] args) {
        for (int i = 0; i < THREADS_AMOUNT; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(
                    EMAILS_AMOUNT_PER_THREAD * i,
                    EMAILS_AMOUNT_PER_THREAD * (i + 1) - 1
            );

            Thread thread = new Thread(senderRunnable);
            thread.start();
        }
    }
}
