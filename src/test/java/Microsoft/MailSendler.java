package Microsoft;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailSendler {
    public static void main(String[] args) {
        SanderRunnable sanderRunnable = new SanderRunnable(0,200);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for(int i=sanderRunnable.getStartindex(); i< sanderRunnable.getEndindex(); i++){
            executor.submit(()->sanderRunnable.run());
        }
executor.shutdown();
    }
}
