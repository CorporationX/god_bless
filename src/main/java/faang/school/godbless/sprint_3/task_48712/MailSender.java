package faang.school.godbless.sprint_3.task_48712;

public class MailSender {

    private static final int COUNT_OF_THREADS = 5;
    private static final int BATCH_OF_LETTERS
            = (int) Math.ceil((double) SenderRunnable.NUMBER_OF_LETTERS / COUNT_OF_THREADS);

    public static void main(String[] args) {
        Thread[] threads = new Thread[COUNT_OF_THREADS];

        int startIndex;
        int endIndex;

        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            startIndex = i * BATCH_OF_LETTERS;
            endIndex = startIndex + BATCH_OF_LETTERS;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Произошло исключение!" + e);
        }

        System.out.println("Все письма отправлены!");
    }
}
