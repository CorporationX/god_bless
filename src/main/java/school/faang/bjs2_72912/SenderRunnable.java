package school.faang.bjs2_72912;

import lombok.Data;

@Data
public class SenderRunnable implements Runnable {

    int startIndex;
    int endIndex;

    public SenderRunnable(int startIndex, int endIndex) throws InterruptedException {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        Thread thread = new Thread(this);
        thread.start();
        thread.join();
    }

    @Override
    public void run() {
        System.out.printf("Mails form Thread %s, batch %d to %d sent\n", Thread.currentThread().getName(),
                startIndex, endIndex);
    }

    public void sendMail(int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            run();
        }
    }
}
