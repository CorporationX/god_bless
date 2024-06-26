package BJS2_11990;

public class Senderrunable implements Runnable {
    int startIndex;
    int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо № " + i + " успешно отправлено");
        }
    }

    Senderrunable(int startIndex, int endIndex) {
        this.endIndex = endIndex;
        this.startIndex = startIndex;
    }
}
