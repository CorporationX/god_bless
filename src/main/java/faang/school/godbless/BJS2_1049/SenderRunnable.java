package faang.school.godbless.BJS2_1049;

public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено " + i);
        }
    }
}
