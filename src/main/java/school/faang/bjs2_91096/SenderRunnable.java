package school.faang.bjs2_91096;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println("Письмо отправлено: " + i);
        }
    }
}
