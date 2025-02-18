package school.faang.sprint3.task_60433;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        validateIndex(startIndex, endIndex);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("The mail %d has been sent\n", i);
        }
    }

    private void validateIndex(int startIndex, int endIndex) {
        if (startIndex < 0) {
            throw new IllegalArgumentException("Start index cant be negative");
        } else if (endIndex < 0) {
            throw new IllegalArgumentException("End index cant be negative");
        } else if (startIndex > endIndex) {
            throw new IllegalArgumentException("Start index cant be more than end index");
        }
    }
}
