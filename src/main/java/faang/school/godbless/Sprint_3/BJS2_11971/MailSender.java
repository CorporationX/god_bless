package faang.school.godbless.Sprint_3.BJS2_11971;

public class MailSender {
    public static void main(String[] args) {
        int totalMessages = 1000;
        int threadsCount = 5;
        int messagesPerThread = totalMessages / threadsCount;

        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int startIndex = i * messagesPerThread;
            int endIndex = (i + 1) * messagesPerThread;
            threads[i] = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все письма отправлены.");
    }
    }
