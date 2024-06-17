package faang.school.godbless.Microsoft;

public class MailSender {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 9;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);
            thread.start();

            try{
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted", e);
            }
        }
    }

}
