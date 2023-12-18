package faang.school.godbless.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int totalEmail = 1000;
        int count = 0;

        for (int i = 0; i < totalEmail; i++) {
            if ((i + 1) % 200 == 0) {
                Thread thread = new Thread(new SenderRunnable(new StackMail(count, i)));
                thread.start();
                thread.join();
                count = i + 1;
            }
        }
        System.out.println("All emails were sent!");
    }
}
