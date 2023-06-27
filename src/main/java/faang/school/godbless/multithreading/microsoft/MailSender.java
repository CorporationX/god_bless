package faang.school.godbless.multithreading.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int start = i * 10 + 1;
            int end = start + 10;

            Thread thread = new Thread(new SenderRunnable(start, end), "Sender-" + (i + 1));
            thread.start();
            thread.join();

            System.out.println("Messages by " + thread.getName() +  " have been successfully sent");
        }
    }
}
