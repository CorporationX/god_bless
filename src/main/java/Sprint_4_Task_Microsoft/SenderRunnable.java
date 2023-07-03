package Sprint_4_Task_Microsoft;

public class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + " Я молодец, я отправил 1 письмо " + i);
        }
    }

    public SenderRunnable(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}
