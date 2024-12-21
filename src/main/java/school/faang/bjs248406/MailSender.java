package school.faang.bjs248406;

public class MailSender {
    private static int startIndex = 1;
    private static int finishIndex = 200;
    private static Thread[] threads = new Thread[5];

    public static void main(String[] args) {
        try {
            int step = 200;
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new SenderRunnable(startIndex, finishIndex));
                threads[i].start();
                startIndex += step;
                finishIndex += step;
            }
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("The all letters is successfully sent");
    }
}
