package school.faang.microsoft;

public class MailSender {
    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {

        SenderRunnable senderRunnable = new SenderRunnable(0, 199);
        SenderRunnable senderRunnable2 = new SenderRunnable(200, 399);
        SenderRunnable senderRunnable3 = new SenderRunnable(400, 599);
        SenderRunnable senderRunnable4 = new SenderRunnable(600, 799);
        SenderRunnable senderRunnable5 = new SenderRunnable(800, 999);

        Thread thread = new Thread(senderRunnable);
        Thread thread2 = new Thread(senderRunnable2);
        Thread thread3 = new Thread(senderRunnable3);
        Thread thread4 = new Thread(senderRunnable4);
        Thread thread5 = new Thread(senderRunnable5);

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            System.out.println("Wait for first 200 mail to finish");
            thread.sleep(1000);
            senderRunnable.join();
            System.out.println("First 200 mails have been sent");

            System.out.println("Wait for second 200 mail to finish");
            thread.sleep(2000);
            senderRunnable2.join();
            System.out.println("Second 200 mails have been sent");

            System.out.println("Wait for third 200 mail to finish");
            thread.sleep(500);
            senderRunnable3.join();
            System.out.println("Third 200 mails have been sent");

            System.out.println("Wait for fourth 200 mail to finish");
            thread.sleep(1500);
            senderRunnable4.join();
            System.out.println("Fourth 200 mails have been sent");

            System.out.println("Wait for last 200 mail to finish");
            thread.sleep(3000);
            senderRunnable5.join();
            System.out.println("Last 200 mails have been sent");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Interrupted in main!");
        }


    }
}
