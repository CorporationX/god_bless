package school.faang.multithread;

public class MailSender {
    private static final Integer NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        for (int i = 0; i < NUMBER_OF_THREADS; i++){
            Thread thread = new Thread(new SenderRunnable(1, 200));
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
