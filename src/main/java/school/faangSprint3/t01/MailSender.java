package school.faangSprint3.t01;

public class MailSender {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        int emailsPerThread = 200;

        for (int i = 0; i < 5; i++) {
            int startIndex = i * emailsPerThread;
            int endIndex = startIndex + emailsPerThread;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все письма успешно отправлены!");
    }
}