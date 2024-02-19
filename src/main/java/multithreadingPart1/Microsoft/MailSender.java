package multithreadingPart1.Microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200;
            Thread thread = new Thread(new SenderRunnable(startIndex, startIndex + 200));
            thread.start();
            thread.join();
        }
    }
}
