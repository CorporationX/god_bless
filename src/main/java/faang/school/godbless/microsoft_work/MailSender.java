package faang.school.godbless.microsoft_work;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            thread.join();
        }
        System.out.println("All messages send");
    }
}
