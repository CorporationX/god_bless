package school.faang.m3_1_parallelism.microsoft;

public class MailSender {
    public static void main(String[] args) {
        int count = 1000;
        int numberOfThreads = 5;
        Thread[] threads = new Thread[numberOfThreads];
        int delimetr = count / numberOfThreads;
        String[] messages = new String[count];
        for (int i = 0; i < count; i++) {
            messages[i] = String.valueOf(i + 1);
        }

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(
                    new SenderRunnable(
                            messages,
                            i * delimetr,
                            (i + 1) * delimetr - 1),
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
