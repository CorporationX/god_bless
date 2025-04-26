package school.faang.bjs2_73138;

public class MailSender {
    private static final int AMOUNT_OF_THREADS = 5;
    private static final int LETTERS_PER_THREAD = 200;

    public static void main(String[] args) {
        Thread[] threads = new Thread[AMOUNT_OF_THREADS];

        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            String name = "Поток - " + i;
            int start = i * LETTERS_PER_THREAD + 1;
            int end = (i + 1) * LETTERS_PER_THREAD;
            threads[i] = new Thread(new SenderRunnable(start, end), name);
        }

        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток прерван: " + threads[i].getName());
            }
        }

        System.out.println("Все письма успешно отправлены!");
    }
}
