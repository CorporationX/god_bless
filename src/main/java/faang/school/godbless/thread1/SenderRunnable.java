package faang.school.godbless.thread1;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex + 1; i++) {
            System.out.println("Отправлено сообщение " + i);
        }
    }
}
