package school.faang.microsoft;

public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо #" + i + " отправлено (поток " +
                    Thread.currentThread().getId() + ")");
        }
    }
}
