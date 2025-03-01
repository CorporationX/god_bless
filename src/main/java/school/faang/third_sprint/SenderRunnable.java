package school.faang.third_sprint;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        validateIndexes(startIndex, endIndex);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    private void validateIndexes(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex < 0) {
            throw new IllegalArgumentException("Индексы не могут быть отрицательными: "
                    + startIndex + ", " + endIndex);
        }
        if (startIndex > endIndex) {
            throw new IllegalArgumentException("Начальный индекс не может быть больше конечного: "
                    + startIndex + ", " + endIndex);
        }
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Письмо №%s успешно отправлено!\n", i);
        }
    }
}
