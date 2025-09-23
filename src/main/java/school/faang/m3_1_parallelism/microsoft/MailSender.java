package school.faang.m3_1_parallelism.microsoft;

public class MailSender {
    public static void main(String[] args) {
        int emailsCount = 1000;
        int numberOfThreads = 5;
        Thread[] threads = new Thread[numberOfThreads];
        int batchSize = emailsCount / numberOfThreads;
        String[] messages = new String[emailsCount];
        for (int i = 0; i < emailsCount; i++) {
            messages[i] = String.valueOf(i + 1);
        }

        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize - 1;
            Thread thread = new Thread(
                    new SenderRunnable(
                            messages,
                            startIndex,
                            endIndex),
                    "Поток № " + (i + 1));
            threads[i] = thread;
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Возникло исключение в процессе работы потока: " + thread.getName());
            }
        }
        System.out.println("Все сообщения обработаны");
    }
}
