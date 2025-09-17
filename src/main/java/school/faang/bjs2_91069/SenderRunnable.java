package school.faang.bjs2_91069;

public record SenderRunnable(int start, int end) implements Runnable {
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            System.out.printf("Письмо [%d] отправлено потоком %s\n", i, Thread.currentThread().getName());
        }
    }
}
