package school.faang.bjs2_89559;

public class MailSender {

    public static final int CURRENT_LETTER_QUANTITY = 1000;
    public static final int THREAD_QUANTITY = 5;
    public static final int BATCH_SIZE = CURRENT_LETTER_QUANTITY / THREAD_QUANTITY;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_QUANTITY];

        for (int i = 0; i < THREAD_QUANTITY; i++) {
            threads[i] = new Thread(new SenderRunnable(i * BATCH_SIZE, ((i + 1) * BATCH_SIZE)));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.printf("Поток %s: Меня преравали в процессе ожидания!", Thread.currentThread().getName());
            }
        }

        System.out.println("Все письма были разосланы!");
    }
}