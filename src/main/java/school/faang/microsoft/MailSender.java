package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) throws Exception {
        int countOfThreads = 5;
        int countOfEmails = 1000;

        Thread[] threads = new Thread[countOfThreads];
        for (int i = 0; i < countOfThreads; i++) {
            int startIndex = i * countOfEmails / countOfThreads;
            int endIndex = startIndex + countOfEmails / countOfThreads;
            threads[i] = new Thread(new SenderRunnable(startIndex + 1, endIndex));
        }

        for (int i = 0; i < countOfThreads; i++) {
            threads[i].start();
        }

        for (int i = 0; i < countOfThreads; i++) {
            threads[i].join();
        }

        System.out.println("All emails sent");
    }
}
