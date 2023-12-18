package faang.school.godbless.YouWorkForMicrosoft;

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
                throw new RuntimeException(e);
            }
            System.out.println("Письмa от " + startIndex + " до " + endIndex + " отправлены");
        }
    }
}
