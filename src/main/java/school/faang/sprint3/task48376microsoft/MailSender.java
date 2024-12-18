package school.faang.sprint3.task48376microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        SenderRunnable runnable = new SenderRunnable(0, 200);
        Thread thread = new Thread(runnable);
        int createdThreads = 0;
        for (int i = 0; i < 5; i++) {
            thread.run();
            createdThreads++;
        }

        thread.join();
        System.out.println("Все письма отправлены");
        System.out.println("Всего создано потоков: " + createdThreads);
    }
}
