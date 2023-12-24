package faang.school.godbless.work_microsoft;

import lombok.AllArgsConstructor;

public class MailSender {

    public static void main(String[] args) {
        int totalThreads = 5;
        int totalMessage = 1000;
        int messagePerThread = totalMessage / totalThreads;

        for (int i = 0; i < totalThreads; i++) {
            int start = i * messagePerThread;
            int end = start + messagePerThread;
            SenderRunnnable senderRunnnable = new SenderRunnnable(start, end);
            Thread thread = new Thread(senderRunnnable);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

@AllArgsConstructor
class SenderRunnnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Message sent");
        }
    }
}