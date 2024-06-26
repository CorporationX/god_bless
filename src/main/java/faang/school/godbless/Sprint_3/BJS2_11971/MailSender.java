package faang.school.godbless.Sprint_3.BJS2_11971;


public class MailSender {
    public static void main(String[] args) {
        final int totalMessages = 1000;
        final int threadsCount = 5;
        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * (totalMessages / threadsCount);
            int endIndex = (i + 1) * (totalMessages / threadsCount);
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }
        for (int i = 0; i < threadsCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все сообщения отправлены!");
    }
}
