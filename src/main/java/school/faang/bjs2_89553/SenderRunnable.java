package school.faang.bjs2_89553;

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public void run() {
        System.out.println("Письмо " + startIndex + " отправлено");
    }
}
