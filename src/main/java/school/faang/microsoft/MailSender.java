package school.faang.microsoft;

public class MailSender {
    public static void main(String[] args) {
        int amountOfLetters = 1000;
        int amountOfThreads = 5;
        int lettersPerThread = amountOfLetters / amountOfThreads;

        Thread[] threads = new Thread[amountOfThreads];

        for (int i = 0; i < amountOfThreads; i++) {
            int startIndex = i * lettersPerThread;
            int endIndex = (i + 1) * lettersPerThread;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Done");
    }
}
