package faang.school.godbless.BaseReception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        MilitaryBase militaryBase1 = new MilitaryBase();
        MilitaryBase militaryBase2 = new MilitaryBase();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(militaryBase1);
        executor.execute(militaryBase2);
        executor.execute(() -> militaryBase1.sendMessage("Hello1", militaryBase2));
        executor.execute(() -> militaryBase1.sendMessage("Hello2", militaryBase2));
        executor.execute(() -> militaryBase2.sendMessage("Bye1", militaryBase1));
        executor.execute(() -> militaryBase2.sendMessage("Bye2", militaryBase1));

        Thread.sleep(3000);
        executor.execute(militaryBase1::stop);
        executor.execute(militaryBase2::stop);

        executor.shutdown();
    }
}
