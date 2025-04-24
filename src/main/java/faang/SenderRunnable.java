package faang;

public final class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(final int startIndex, final int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int index = startIndex; index <= endIndex; index++) {
            System.out.println("Письмо отправлено: " + index);
        }
    }
}
