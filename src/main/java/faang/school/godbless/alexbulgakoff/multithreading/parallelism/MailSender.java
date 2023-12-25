package faang.school.godbless.alexbulgakoff.multithreading.parallelism;

/**
 * @author Alexander Bulgakov
 */

public class MailSender {
    static final int COUNT_THREADS = 5;
    private static final int NUMBER_OF_LETTERS_PER_THREAD = 50;
    public static void main(String[] args) {


        for (int i = 0; i < COUNT_THREADS; i++) {
            int startIndex = i * NUMBER_OF_LETTERS_PER_THREAD + 1;
            int endIndex = startIndex + NUMBER_OF_LETTERS_PER_THREAD;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
