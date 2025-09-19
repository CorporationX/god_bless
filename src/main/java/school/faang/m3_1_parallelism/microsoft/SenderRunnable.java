package school.faang.m3_1_parallelism.microsoft;

public class SenderRunnable implements Runnable {

    private final int startIndex;
    private final int endIndex;
    private final String[] messages;

    public SenderRunnable(String[] messages, int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.messages = messages;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            for (int i = startIndex; i <= endIndex; i++) {
                Thread.sleep(2);
            }
            System.out.println(threadName + " закончил обработку писем с " +
                    messages[startIndex] + " по " + messages[endIndex]);
        } catch (InterruptedException e) {
            System.out.println("Возникло исключение в процессе работы потока: " + threadName);
        }
    }
}
