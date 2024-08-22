package faang.school.godbless.WorkAtMicrosoft;

public class MailSender {
    private static int totalMail = 1000;
    private static int threadAmount = 5;

    public static void main(String[] args) {
        Thread[] threads = new Thread[threadAmount];
        int mailPerBatch = totalMail / threadAmount;
        for (int i = 0; i < threadAmount; i++) {
            int startIndex = i * mailPerBatch;
            int endIndex = startIndex + mailPerBatch;

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

        System.out.println("All mail has been sent");
    }
}
