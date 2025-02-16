package school.faang;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        validateIndices(startIndex, endIndex);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    private void validateIndices(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex < 0) {
            throw new IllegalArgumentException("Indices can't be less than 0.");
        } else if (endIndex < startIndex) {
            throw new IllegalArgumentException("startIndex can't be greater than endIndex.");
        }
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Mail %d has been sent.\n", i);
        }
    }
}
