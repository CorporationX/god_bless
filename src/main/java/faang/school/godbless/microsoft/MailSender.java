package faang.school.godbless.microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int startletterId = i*300+1;
            int endletterId = startletterId+300;
            Thread thread = new Thread(new SenderRunnable(startletterId,endletterId));
            thread.start();
            thread.join(500);
            System.out.println("operation completed");
        }
    }
}
