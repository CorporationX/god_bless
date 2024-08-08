package faang.school.godbless.optTask.optStrategy;

import faang.school.godbless.optTask.data.DataCenter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
public class OptThread implements Runnable{
    OptimizationStrategy strategy;
    DataCenter dataCenter;

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            strategy.optimize(dataCenter);
            System.out.println("data center " + dataCenter + " optimized");
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                break;
            }
        }
    }
}
