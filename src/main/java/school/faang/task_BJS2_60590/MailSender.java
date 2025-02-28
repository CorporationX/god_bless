package school.faang.task_BJS2_60590;

public class MailSender {
    private static final int amountOfMessage = 1000;
    private static final int amoutOfThreads = 5;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[amoutOfThreads];
        for (int i = 0; i < amoutOfThreads; i++) {
            int startIndex = (i * (amountOfMessage / amoutOfThreads)) + 1;
            int endIndex = (i + 1) * (amountOfMessage / amoutOfThreads) + 1;
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