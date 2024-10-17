package workAtMicrosoft_37784;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int countThreads = 5;
        int sizeBatch = totalMessages / countThreads;
        Thread[] threads = new Thread[countThreads];

        for (int i = 0; i < countThreads; i++) {
            int start = sizeBatch * i;
            int end = sizeBatch * (i + 1);
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Все письма отправлены");
    }
}
