package school.faang.sprint3.bjs_48265;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalCount = 1000;
        int threadsAmount = 5;
        int batchSize = totalCount / threadsAmount;

        Thread[] threadPool = new Thread[threadsAmount];

        for (int i = 0; i < threadsAmount; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;
            SenderRunnable partMails = new SenderRunnable(startIndex, endIndex);
            threadPool[i] = new Thread(partMails);
            threadPool[i].start();
        }

        for (Thread thread : threadPool) {
            thread.join();
        }

        System.out.println("Все письма успешно отправлены!");
    }
}
