package school.faang.bjs2_73032;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        for (Chore c : weasleyFamily.getToDo()) {
            weasleyFamily.getExecutorService().execute(c);
        }
        weasleyFamily.getExecutorService().shutdown();
        try {
            if (!weasleyFamily.getExecutorService().awaitTermination(5, TimeUnit.SECONDS)) {
                weasleyFamily.getExecutorService().shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
