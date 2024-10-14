package school.faang.sprint_3.bjs2_37778_youWorkAtMicrosoft;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено: " + i);
        }
    }
}
