package faang.school.godbless.workInMicrosoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int lettersForThread = 200;
        for (int i = 0; i < 5; i++) {
            var thread = new Thread(new SenderRunnable(lettersForThread * i, lettersForThread * i + lettersForThread));
            thread.start();
            thread.join();
        }
    }
}
