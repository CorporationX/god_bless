package faang.school.godbless.Sprint4.Task_1_Microsoft;

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;
    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Успешно отправлено письмо №" + (i + 1));
        }
    }
}
