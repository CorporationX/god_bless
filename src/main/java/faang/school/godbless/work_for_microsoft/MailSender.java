package faang.school.godbless.work_for_microsoft;

public class MailSender {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            SenderRunnable sender = new SenderRunnable(i*200, i*200 + 200);
            Thread thread = new Thread(sender);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All messages delivered!");
    }
}
