package faang.school.godbless.task30;

public class MailSender {
    public static void main(String[] args) {
        int threadQuantity=5;
        int mailQuantity=1000;
        int step = mailQuantity/threadQuantity;
        int startPosition=-step;
        int endPosition=0;

        for (int i = 0; i < threadQuantity; i++) {
            startPosition = startPosition + step;
            endPosition = endPosition + step;
            Thread thread= new Thread(new SenderRunnable(startPosition,endPosition));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
