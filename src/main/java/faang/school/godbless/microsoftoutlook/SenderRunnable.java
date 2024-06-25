package faang.school.godbless.microsoftoutlook;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(Thread.currentThread().getName() + ". Message" + i + " is processed");
        }
    }
}
