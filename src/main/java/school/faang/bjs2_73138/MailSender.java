package school.faang.bjs2_73138;

public class MailSender {
    private static final int amountOfThreads = 5;
    private static final int lettersPerThread = 200;

    public static void main(String[] args) {
        Thread[] threads = new Thread[amountOfThreads];

        for (int i = 0; i < amountOfThreads; i++) {
            String name = "Поток - " + i;
            int start = i * lettersPerThread + 1;
            int end = (i + 1) * lettersPerThread;
            threads[i] = new Thread(new SenderRunnable(start, end), name);
        }

        for (int i = 0; i < amountOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток прерван: " + threads[i].getName());
            }
        }

        System.out.println("Все письма успешно отправлены!");
    }
}
