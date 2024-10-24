package school.BJS2_39195;

import java.util.concurrent.atomic.AtomicInteger;

public class SensorData {

    private AtomicInteger sum = new AtomicInteger();
    private AtomicInteger count = new AtomicInteger(0);

    public void addData(double data) {
        sum.addAndGet((int) data);
        count.incrementAndGet();
    }

    public double getAverage() {
        int sumItog = sum.get();
        int countItog = count.get();
        return countItog > 0 ? (double) sumItog / countItog : 0;
    }
}
