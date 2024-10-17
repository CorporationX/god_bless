package school.faang.multithreading.jobInMicrosoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int messages = 1000;
        int threads = 5;
        int emailOnThread = messages / threads;

        Thread[] threadArray = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            int start = i*emailOnThread;
            int end = (i+1)*emailOnThread;
            threadArray[i] = new Thread(new SenderRunnable(start, end));
            threadArray[i].start();
        }

        for (int i = 0; i < threads; i++) {
            threadArray[i].join();
        }

        System.out.println("Потоки завершили работу");
    }
}
