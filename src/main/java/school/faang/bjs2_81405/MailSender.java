package school.faang.bjs2_81405;

public class MailSender {
    private static final int LETTERS_PER_THREAD = 200;
    private static final int TOTAL_THREADS = 5;

    public static void main(String[] args) {
        Thread[] threads = new Thread[TOTAL_THREADS];

        for (int i = 0; i < TOTAL_THREADS; i++) {
            int start = i * LETTERS_PER_THREAD + 1;
            int end = start + LETTERS_PER_THREAD - 1;
            threads[i] = new Thread(new SenderRunnable(start, end, i + 1));
            threads[i].start();
        }

        for (int i = 0; i < TOTAL_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Письма все отправлены успешно");
    }
}
