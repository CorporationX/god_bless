package faang.school.godbless;

public class MailSender {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = (i+1) * 200;
            SenderRunnable sender = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread (sender);
            thread.start();
        }
    }
}
