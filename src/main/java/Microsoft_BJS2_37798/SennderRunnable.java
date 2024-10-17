package Microsoft_BJS2_37798;

public class SennderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    SennderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Mail has been sent");
        }
    }
}
