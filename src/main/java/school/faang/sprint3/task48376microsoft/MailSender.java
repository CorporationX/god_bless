package school.faang.sprint3.task48376microsoft;

public class MailSender {
    public static void main(String[] args) {
        final int START = 0;
        final int END = 200;

        int createdThreads = 0;

        for (int i = 0; i < 5; i++) {
            SenderRunnable runnable = new SenderRunnable(START, END);
            Thread thread = new Thread(runnable);
            thread.start();
            createdThreads++;

            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Все письма отправлены!!!");
        System.out.println("Всего создано потоков: " + createdThreads);
    }
}
