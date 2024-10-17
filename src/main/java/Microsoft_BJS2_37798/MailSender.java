package Microsoft_BJS2_37798;

public class MailSender {
    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        int emailsPerThread = 200;

        for (int i = 0; i < 5; i++) {
            int startIndex = i * emailsPerThread + 1;
            int endIndex = startIndex + emailsPerThread - 1;
            threads[i] = new Thread(new SennderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All emails have been sent");
    }
}
