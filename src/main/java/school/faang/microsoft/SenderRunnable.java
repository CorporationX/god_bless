package school.faang.microsoft;

public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;
    private final String stream;

    public SenderRunnable(int startIndex, int endIndex, String stream) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.stream = stream;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(stream + " " + Thread.currentThread().getName() + " Выполнено = " + i);
        }
    }
}
