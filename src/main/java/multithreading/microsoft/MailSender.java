package multithreading.microsoft;

public class MailSender {
    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 0; i < 5; i++) {
            thread = new Thread(new SenderRunnable(i * 50, i * 50 + 50));
            thread.start();
        }
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Success, all letters have been sent");

    }
}
