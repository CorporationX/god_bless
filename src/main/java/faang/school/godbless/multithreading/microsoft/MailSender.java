package faang.school.godbless.multithreading.microsoft;

public class MailSender {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;
            var thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
        }
        System.out.printf("Sending is complete. From %s", Thread.currentThread().getName());
    }
}
