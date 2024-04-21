package faang.school.godbless.work_in_microsoft;


public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int messagesPerThread = 200;
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int startIndex = i * messagesPerThread;
            int endIndex = Math.min((i + 1) * messagesPerThread, totalMessages);
            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            threads[i] = new Thread(senderRunnable);
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка в выводе сообщения");
        }

        System.out.println("Все сообщения отправлены.");
    }
}
