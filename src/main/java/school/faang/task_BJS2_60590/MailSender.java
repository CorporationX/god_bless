package school.faang.task_BJS2_60590;

public class MailSender {
    private static final int amountOfMessage = 1000;
    private static final int amountOfThreads = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[amountOfThreads];

        for (int i = 0; i < amountOfThreads; i++) {
            int startIndex = (i * (amountOfMessage / amountOfThreads)) + 1;
            int endIndex = (i + 1) * (amountOfMessage / amountOfThreads) + 1;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            threads[i] = thread;
            thread.start();
        }

        //ждем завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread " + thread + " was interrupted " + e.getMessage());
            }
        }

        System.out.println("All messages are sent");
    }
}