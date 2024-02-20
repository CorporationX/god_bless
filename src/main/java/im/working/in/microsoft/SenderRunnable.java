package im.working.in.microsoft;

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run(){
        for(int j = startIndex; j <= endIndex; j++) {
            System.out.println("Message " + j + " Sent successfully");
        }
    }
}
