package school.faang.workingtomicrosoft;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("Письмо %d отправлено%n", i);
        }
    }
}
