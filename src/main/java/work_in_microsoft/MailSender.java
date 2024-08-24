package work_in_microsoft;

public class MailSender {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; ++i) {
            int startIndex = i * 200;
            int endIndex = startIndex + 200;
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            thread.start();
            thread.join();
        }
        System.out.println("Все сообщения отправлены");
    }
}
