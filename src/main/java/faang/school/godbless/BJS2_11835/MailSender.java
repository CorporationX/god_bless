package faang.school.godbless.BJS2_11835;

public class MailSender {

    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i += 200) {

            Thread thread = new Thread(new SenderRunnable(i, i + 200));

            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Mails are sent");
    }
}
