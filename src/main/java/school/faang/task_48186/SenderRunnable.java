package school.faang.task_48186;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        if ((startIndex < 0 || endIndex < 0) && startIndex >= endIndex) {
            throw new IllegalArgumentException("Invalid values");
        }
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Письмо отправлено: %d%n", i);
        }
    }

}
