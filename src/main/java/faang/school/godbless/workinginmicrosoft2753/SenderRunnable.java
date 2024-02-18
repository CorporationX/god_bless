package faang.school.godbless.workinginmicrosoft2753;

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = this.startIndex; i <= this.endIndex; i++) {
            System.out.printf("E-mail %d sent!%n", i);
        }
    }
}
