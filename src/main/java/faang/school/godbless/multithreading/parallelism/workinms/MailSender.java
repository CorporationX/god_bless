package faang.school.godbless.multithreading.parallelism.workinms;

public class MailSender {

    private static final int BUTCH_SIZE = 200;

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            int startIndex = i * BUTCH_SIZE + 1;
            Thread thread1 = new Thread(new SenderRunnable(startIndex, startIndex + BUTCH_SIZE - 1));
            thread1.start();
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("All done!");

    }
}
