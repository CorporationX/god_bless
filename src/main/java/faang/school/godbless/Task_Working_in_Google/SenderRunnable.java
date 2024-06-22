package faang.school.godbless.Task_Working_in_Google;

public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int start, int end) {
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("invalid index");
        } else {
            this.startIndex = start;
            this.endIndex = end;
        }
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("the message " + i + " has been sent");
        }
    }

}
