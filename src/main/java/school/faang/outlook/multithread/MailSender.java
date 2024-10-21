package school.faang.outlook.multithread;

public class MailSender {
    public static void main(String[] args) {
        int threadCounter = 5;
        int totalMessages = 1000;
        int eachThread = totalMessages / threadCounter;

        Thread[] threads = new Thread[eachThread];

        for (int i = 0; i < totalMessages; i++) {
            int start = i * eachThread;
            int end = (i + 1) * eachThread;
            threads[i] = new Thread(new SenderRunnable(start, end));
            threads[i].start();
        }

        for (int i = 0; i < threadCounter; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все письма успешно отправлены.");
    }
}
