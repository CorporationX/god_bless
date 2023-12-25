package faang.school.godbless.YouWorkForMicrosoft;

public class MailSender {
    public static void main(String[] args) {
        final int COUNT_OF_THREADS = 5;
        final int COUNT_MESSAGE_IN_THREAD = 200;
        for (int i = 0; i < COUNT_OF_THREADS; i++) {
            int startIndex = i * COUNT_MESSAGE_IN_THREAD + 1;
            int endIndex = startIndex + COUNT_MESSAGE_IN_THREAD;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Письмa от " + startIndex + " до " + endIndex + " отправлены");
        }
    }
}
