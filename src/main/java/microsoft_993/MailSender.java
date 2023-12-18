package microsoft_993;

public class MailSender {
    public static int countThreads = 5;
    public static int countMessage = 1000;
    public static int countMessageOfThread = countMessage/countThreads;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            int start = i * countMessageOfThread;
            int end = start + countMessageOfThread;
            Thread thread = new Thread(() -> new SenderRunnable(start, end).run());
            thread.start();
            thread.join();
        }
        System.out.println("Все сообщения отправлены");
    }
}