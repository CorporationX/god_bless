package microsoft_993;

public class SenderRunnable implements Runnable{
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Письма отправлены (с-по) " + startIndex + " - " + endIndex);
    }
}