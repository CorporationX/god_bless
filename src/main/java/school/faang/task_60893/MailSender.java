package school.faang.task_60893;

public class MailSender {
    public static void main(String[] args) {
        int emailPerThread = 200;
        int numThreads = 5;

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * emailPerThread;
            int endIndex = (i + 1) * emailPerThread;

            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(String.format("Ошибка: Поток %d был прерван.", i),
                        e);
            }
        }

        System.out.println("Все письма успешно отправлены!");
    }
}
