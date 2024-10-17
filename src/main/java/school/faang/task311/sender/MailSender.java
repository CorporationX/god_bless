package school.faang.task311.sender;

public class MailSender {
    private static int mailSize = 200;

    public static void main(String[] args){
        Thread[] pull  = new Thread[5];

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SenderRunnable(mailSize * i, mailSize * (i + 1)));
            thread.start();
            pull[i]=thread;
        }

        for(Thread thread : pull){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
    }
}
