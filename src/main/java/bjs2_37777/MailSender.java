package bjs2_37777;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        Thread sendersThread = new Thread(() -> {
            for (int i = 1; i <= 1000; i += 200) {
                new Thread(new SenderRunnable(i, i + 199)).start();
            }
        });

        sendersThread.start();
        sendersThread.join();

        System.out.println("All done!");
    }
}
