package faang.school.godbless;

public class MailSender {
    public static void main(String[] args) {
        final int MESSAGE_FOR_MAIL = 200;

        Thread thread;
        int startIndex;
        int endIndex;
        for(int i = 0; i < 5; i++){
            startIndex = i * MESSAGE_FOR_MAIL + 1;
            endIndex = startIndex + MESSAGE_FOR_MAIL - 1;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            thread = new Thread(() -> senderRunnable.run());

            thread.start();
        }
    }
}
