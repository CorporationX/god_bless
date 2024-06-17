package faang.school.godbless.working_in_microsoft;

public class MailSender {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200 + 1;
            int endIndex = startIndex + 200;

            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

        System.out.println("Sending mails successfully end");
    }
}
