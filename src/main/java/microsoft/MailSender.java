package microsoft;

public class MailSender {

    public static void main(String[] args) {
        int startIndex = 0;
        int endindex = 200;

        for (int i = 0; i < 5; i++) {
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endindex);
            Thread thread = new Thread(senderRunnable);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            startIndex += 200;
            endindex += 200;
        }

    }

}
