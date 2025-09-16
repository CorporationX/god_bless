package school.faang.bjs2_91212;

public class MailSender {
    public static void main(String[] args) {
        int totalEmails = 1000;
        int threadCount = 5;
        int emailForThread = totalEmails / threadCount;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int startIndex = i * emailForThread + 1;
            int endIndex = (i + 1) * emailForThread;

            SenderRunnable task = new SenderRunnable(startIndex, endIndex);

            Thread thread = new Thread(task, "Email Sender-" + (i + 1));

            threads[i] = thread;

            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
                System.out.println("Поток " + thread.getName() + " завершил работу");
            } catch (InterruptedException e) {
                System.out.println("Ожидание прервано для потока: " + thread.getName());
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Все потоки завершили работу, письма отправлены!");
    }
}
