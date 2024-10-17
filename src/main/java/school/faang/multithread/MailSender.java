package school.faang.multithread;

public class MailSender {
    public static final int MESSAGES_PER_THREAD = 200;
    public static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_THREADS; i++){
            int startMessage = i * MESSAGES_PER_THREAD + 1;
            int endMessage = startMessage + MESSAGES_PER_THREAD - 1;

            Thread thread = new Thread(new SenderRunnable(startMessage, endMessage));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException("Ошибка в работе потока: " + e.getMessage());
            }
        }

        System.out.println("Все письма отправлены.");
    }
}
