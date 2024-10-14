package workAtMicrosoft_37784;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalMessages = 1000;
        int countThreads = 5;
        int sizeBatch = totalMessages / countThreads;

        for (int i = 0; i < countThreads; i++) {
            int start = sizeBatch * i;
            int end = sizeBatch * (i + 1);
            Thread thread = new Thread(new SenderRunnable(start, end));
            thread.start();
            thread.join();
        }

        System.out.println("Все письма отправлены");
    }
}
