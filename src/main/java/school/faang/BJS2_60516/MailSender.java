package school.faang.BJS2_60516;

public class MailSender {

    public static void main(String[] args) {
        int maxMailsThread = 200;

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * maxMailsThread + 1;
            int endIndex = startIndex + maxMailsThread - 1;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Произошел сбой отправки сообщений!");
            }
        }
        System.out.println("Все письма отправлены!");
    }
}
