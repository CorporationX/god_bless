package faang.school.godbless.workInMicrosoft;

public class MailSender {

    public static void main(String[] args) {
        int threadsNumber = 5;
        int totalMessagesNumber = 1000;
        int messagesPerThread = totalMessagesNumber / threadsNumber;
        int messagesSent = 0;
        Thread[] threads = new Thread[threadsNumber];

        for (int i = 0; i < threadsNumber; i++) {
            int startIndex = messagesSent + 1;
            int endIndex = startIndex + messagesPerThread - 1;
            if (totalMessagesNumber - endIndex < messagesPerThread) {
                endIndex = totalMessagesNumber;
            }
            Thread thread = new Thread(new SenderRunnable(startIndex, endIndex));
            threads[i] = thread;
            thread.start();
            messagesSent += (endIndex - startIndex + 1);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted");
            }
        }
        System.out.println("Total amount of messages sent: " + messagesSent);

    }
}
