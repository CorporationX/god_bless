package im.working.in.microsoft;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        int messagesPerThread = 200;
        int totalMessages = 1050;
        List<Thread> senderThreads = new ArrayList<>();

        for (int i = 0; i <= totalMessages / messagesPerThread; i++) {
            int startIndex = i * messagesPerThread + 1;
            int endIndex = Math.min((i + 1) * messagesPerThread, totalMessages);

            SenderRunnable senderRunnable = new SenderRunnable(startIndex, endIndex);
            Thread senderThread = new Thread(senderRunnable);

            senderThreads.add(senderThread);
            senderThread.start();
        }

        try {
            for (Thread thread : senderThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
