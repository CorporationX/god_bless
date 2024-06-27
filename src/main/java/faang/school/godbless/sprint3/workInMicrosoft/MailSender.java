package faang.school.godbless.sprint3.workInMicrosoft;


public class MailSender {

    public static void main(String[] args) {
        try {

            int numberOfThreads = 5;
            int mailRangeSize = 200;

            for (int i = 0; i < numberOfThreads; i++) {
                int start = i * 200;
                int end = (i + 1) * mailRangeSize - 1;

                SenderRunnable senderRunnable = new SenderRunnable(start, end);
                Thread thread = new Thread(senderRunnable);
                thread.start();
                thread.join();
            }

            System.out.println("All threads have done");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
