package faang.school.godbless.kxnvg.microsoft;

public class MailSender {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int startIndex = 200 * i + 1;
            int endIndex = startIndex + 199;

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread thread = new Thread(senderRunnable);

            thread.start();
            thread.join();
        }
        System.out.println("Все письма отпрпвлены");
    }
}
