package youWorkMicrosoft;

public class SenderRunnable implements Runnable{
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        System.out.printf("Сообщения с %d по %d отправлены \n", startIndex, endIndex);
    }
}
