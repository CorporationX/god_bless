package faang.school.godbless.microsoft;

public class MailSender {

    public static final int THREAD_COUNT = 5;

    public static final int MESSAGES_PART = 200;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * MESSAGES_PART + 1;
            int endIndex = startIndex + MESSAGES_PART;

            Thread thread = new Thread(() -> new SenderRunnable(startIndex, endIndex).run());

            thread.start();
            thread.join();

            System.out.println(thread.getName() + " завершил работу");
        }
    }
}
