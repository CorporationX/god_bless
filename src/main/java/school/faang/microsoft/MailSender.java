package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) {
        int threadsCount = 5;
        int messagesCount = 1000;
        int startIndex = 1;
        int endIndex = messagesCount / threadsCount;
        Thread[] threads = new Thread[threadsCount];

        System.out.println("Начало отправки");
        for (Thread thread : threads) {
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            startIndex = endIndex + 1;
            endIndex = endIndex + messagesCount / threadsCount;
            thread = new Thread(senderRunnable);
            thread.start();
        }
    }
}
