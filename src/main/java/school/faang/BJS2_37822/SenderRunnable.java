package school.faang.BJS2_37822;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;
    private static int totalThreads = 0;
    private final int threadNumber;
    private final List<Message> msgList;
    private final static AtomicInteger sendCounter = new AtomicInteger(0);

    public SenderRunnable(List<Message> msgList, int startIndex, int endIndex) {
        this.msgList = msgList;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        threadNumber = totalThreads++;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Msg Number: " + sendCounter.getAndIncrement() + " From thread: " +
                    threadNumber + "  " + msgList.get(i));
        }
    }
}
