package school.faang.bjs2_89559;

public record SenderRunnable(int startIndex, int endIndex) implements Runnable {
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.printf("Отправлено письмо: %d", i);
            System.out.println();
        }
    }
}