package Microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++){
            int startIndex = i * 100 + 1;
            int endIndex = i * 100 + 1;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));

            thread.start();
            thread.join();
        }
    }
}
