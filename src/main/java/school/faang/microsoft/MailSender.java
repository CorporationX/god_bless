package school.faang.microsoft;

public class MailSender {
    public void sendMails(int totalEmails, int emailsPerThread) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * emailsPerThread;
            int endIndex = startIndex + emailsPerThread;
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

        System.out.println("Все письма успешно отправлены!");
    }
}
