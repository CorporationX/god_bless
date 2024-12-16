package school.faang.task_48117;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (i == endIndex) {
                System.out.printf("Письма с %s по %s отправлены!%n", startIndex + 1, endIndex);
            }
        }
    }
}
