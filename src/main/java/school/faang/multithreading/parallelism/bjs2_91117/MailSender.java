package school.faang.multithreading.parallelism.bjs2_91117;

public class MailSender {

    public static void main(String[] args) {
        final Thread firstSender = new Thread(new SenderRunnable(1, 200));
        final Thread secondSender = new Thread(new SenderRunnable(201, 400));
        final Thread thirdSender = new Thread(new SenderRunnable(401, 600));
        final Thread fourthSender = new Thread(new SenderRunnable(601, 800));
        final Thread fifthSender = new Thread(new SenderRunnable(801, 1000));

        System.out.println("Старт отправки писем");

        firstSender.start();
        secondSender.start();
        thirdSender.start();
        fourthSender.start();
        fifthSender.start();

        threadJoin(firstSender);
        threadJoin(secondSender);
        threadJoin(thirdSender);
        threadJoin(fourthSender);
        threadJoin(fifthSender);

        System.out.println("Письма успешно отправлены");
    }

    private static void threadJoin(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Поток %s был остановлен%n", thread.getName());
        }
    }
}