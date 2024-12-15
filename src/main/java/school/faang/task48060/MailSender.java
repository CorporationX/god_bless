package school.faang.task48060;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int total = 1000;
        int countThreads = 5;
        int batch = total / countThreads;

        Thread[] threads = new Thread[countThreads];

        for (int i = 0; i < countThreads; i++) {
            int start = i * batch;
            int end = (i + 1) * batch;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Все письма отправлены");
    }
}
