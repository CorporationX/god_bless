package Microsoft;

public class SanderRunnable implements Runnable {
    private int startindex;
    private int endindex;

    public SanderRunnable(int startindex, int endindex) {
        this.startindex = startindex;
        this.endindex = endindex;
    }

    public int getStartindex() {
        return startindex;
    }

    public int getEndindex() {
        return endindex;
    }

    @Override
    public void run() {
        for (int i = startindex + 1; i <= endindex; i++) {
            System.out.println("Send letter № " + i + " letter sent by stream number" + Thread.currentThread().getName());
        }
    }
}
