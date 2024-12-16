package school.faang.workinginmicrosoft;

public class SenderRunnable implements Runnable {
    int startIndex;
    int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        System.out.println("Письмо отправлено");
    }
}
