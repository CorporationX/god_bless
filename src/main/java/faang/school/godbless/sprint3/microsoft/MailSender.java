package faang.school.godbless.sprint3.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 801; i += 200) {
            Thread thread = new Thread(new SenderRunnable(i, i + 200));
            thread.start();
            thread.join();
        }

    }
}
