package faang.school.godbless.parallelMailSender;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 1000; i+=200) {
            SenderRunnable sender = new SenderRunnable(i, i + 199);
            Thread thread = new Thread(sender);
            thread.start();
        }

        System.out.println("All letters have been sent");
    }
}
