package school.faang.bjs248406;

public class MailSender {
    public static void main(String[] args) {
        int startIndex = 1;
        int finishIndex = 200;
        Thread[] threads = new Thread[5];
        try {
            for (int i = 0; i < 5; i++) {
                threads[i] = new Thread(new SenderRunnable(startIndex, finishIndex));
                threads[i].start();
                startIndex += 200;
                finishIndex += 200;
            }
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("The all letters is successfully sent");
    }
}
