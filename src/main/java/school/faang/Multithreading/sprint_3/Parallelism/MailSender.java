package school.faang.Multithreading.sprint_3.Parallelism;

public class MailSender {
    public static void main(String[] args) {
        int allMessages = 1000;
        int countThreads = 5;
        int batchSize = allMessages / countThreads;

        Thread[] threads = new Thread[countThreads];

        for (int i = 0; i < countThreads; i++) {
            int start = i * batchSize + 1;
            int end = (i + 1) * batchSize;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (int i = 0; i < countThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Отправка всех писем завершена");
    }
}
