package faang.school.godbless.Microsoft;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void sendMail(int i) {
        System.out.println("Mail #" + i + " sent successful");
    }

    @Override
    public void run() {
        for (int i = this.startIndex; i <= this.endIndex; i++) {
            sendMail(i);
        }
    }
}
