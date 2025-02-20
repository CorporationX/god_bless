package school.faang;

public class MailSender {
    public static void main(String[] args) {

        int totalMail = 1000;
        int oneThread = 200;
        int numberThread = totalMail / oneThread;

        Thread[] threads = new Thread[numberThread];
        for (int i = 0; i < numberThread; i++) {
            int startIndex = i * oneThread;
            int endIndex = startIndex + oneThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все письма отправлены");
    }
}
