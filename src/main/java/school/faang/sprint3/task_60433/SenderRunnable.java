package school.faang.sprint3.task_60433;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex, int totalMessage) {
        validateIndex(startIndex, endIndex, totalMessage);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("The mail %d has been sent by thread: %s\n", i, Thread.currentThread().getName());
        }
    }

    private void validateIndex(int startIndex, int endIndex, int totalMessages) {
        if (startIndex < 0) {
            throw new IllegalArgumentException("Start index can't be negative");
        } else if (endIndex < 0) {
            throw new IllegalArgumentException("End index can't be negative");
        } else if (startIndex > endIndex) {
            throw new IllegalArgumentException("Start index can't be more than end index");
        } else if (endIndex > totalMessages) {
            throw new IllegalArgumentException("End index can't exceed total number of messages");
        }
    }
}
