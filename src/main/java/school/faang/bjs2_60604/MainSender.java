package school.faang.bjs2_60604;

public class MainSender {
    private static final int THREAS_COUNT = 5;
    public static void main(String[] args)  throws InterruptedException{
        Thread [] threads = new Thread[THREAS_COUNT];
        for (int i = 0; i<THREAS_COUNT; i++) {

        }
        for (Thread thread : threads) {
            thread.join();
        }


    }
}
