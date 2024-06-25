package faang.school.godbless.BJS2_7095;

public class Main {

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        int batchSize = 20;
        for(int i = 0 ; i < 5; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(i * batchSize, (i + 1) * batchSize - 1);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("All messages have been sent successfully");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
