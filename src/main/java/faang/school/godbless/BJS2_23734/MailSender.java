package faang.school.godbless.BJS2_23734;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 199;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("All letters was send");
    }
}
