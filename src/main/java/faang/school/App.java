package faang.school;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        MilitaryBase base1 = new MilitaryBase();
        MilitaryBase base2 = new MilitaryBase();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(base1);
        executorService.execute(base2);

        try {
            base1.sendMessage("Hello1 from Base1 to Base2", base2);
            base1.sendMessage("Hello2 from Base1 to Base2", base2);
            base1.sendMessage("Hello3 from Base1 to Base2", base2);
            base1.sendMessage("Hello4 from Base1 to Base2", base2);
            base1.sendMessage("Hello5 from Base1 to Base2", base2);
            base1.sendMessage("Hello6 from Base1 to Base2", base2);
            base2.sendMessage("Greetings1 from Base2 to Base1", base1);
            base2.sendMessage("Greetings2 from Base2 to Base1", base1);
            base2.sendMessage("Greetings3 from Base2 to Base1", base1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.submit(() -> {
            while (true) {
                if (base1.getInbox().isEmpty()) {
                    base1.stop();
                    break;
                }
            }
        });
        executorService.submit(() -> {
            while (true) {
                if (base2.getInbox().isEmpty()) {
                    base2.stop();
                    break;
                }
            }
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
