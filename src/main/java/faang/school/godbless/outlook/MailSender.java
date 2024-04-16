package faang.school.godbless.outlook;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        while (i < 1000) {
            Thread thread = new Thread(new SenderRunnable(i, i + 199));
            i += 200;
            thread.start();
            thread.join();
        }
        System.out.println("All email sends");
    }
}
