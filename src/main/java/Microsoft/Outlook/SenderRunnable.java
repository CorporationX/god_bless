package Microsoft.Outlook;

public class SenderRunnable implements Runnable {
    private final int startIndex;
    private final int endIndex;

    public SenderRunnable(int startIndex, int endIndex) {
        if (startIndex <= 0 || endIndex <= 0) {
            throw new IllegalArgumentException("Начальный и конечный индекс не должны быть отрицательны");
        }
        if (startIndex > endIndex) {
            throw new IllegalArgumentException("Начальный индекс должен быть меньше или равен конечному");
        }
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.println("Письмо номер " + i + " обработано потоком " + Thread.currentThread().getName());

            try {
                Thread.sleep(50);
            } catch (InterruptedException error) {
                Thread.currentThread().interrupt();
                System.err.println("Поток " + Thread.currentThread().getName() + " был прерван");
            }
        }
    }
}
