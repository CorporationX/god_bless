package school.faang.bjs2_91074;

public class MailSender {
    public static void main(String[] args) throws  InterruptedException {
        int totalMessages = 1000;
        int threadCount = 5;
        int messagesPerThread = totalMessages / threadCount;

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; 1 < threadCount; i++) {
            int start = i * messagesPerThread;
            int end =
        }
    }
}
