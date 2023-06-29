package faang.school.godbless;

public class MailSender {
    public static void main(String... args) throws InterruptedException {
        int messagesPerThread = 200;
        int threadsCount = 5;
        for (int i = 0; i < threadsCount; i++) {
            var thread = new Thread(new SenderRunnable(messagesPerThread * i, messagesPerThread * i + messagesPerThread));
            thread.start();
            thread.join();
        }
    }
}
