package faang.school.godbless.MultithreadingParallelismThread.WorkAtMicrosoft;


public class MailSender {
    public static void main(String[] args) {
        int threadsCount = 5;
        int emailsInThread = 200;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * emailsInThread;
            int endIndex = (i + 1) * emailsInThread;
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Ошибка потока");
            }
        }

        System.out.println("Все сообщения отправлены");
    }
}
