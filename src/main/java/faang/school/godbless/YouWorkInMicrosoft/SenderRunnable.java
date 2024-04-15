package faang.school.godbless.YouWorkInMicrosoft;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int count = startIndex; count <= endIndex; count++) {
            System.out.println("Письмо " + count + " отправлено!");
        }
    }
}
