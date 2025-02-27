package bjs2_62545;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class SensorData {
    private double sum;
    @Getter
    private int count;

    private final ReadWriteLock locker = new ReentrantReadWriteLock();

    private SensorData(double sum, int count) {
        this.sum = sum;
        this.count = count;
    }

    public SensorData(double value) {
        sum = value;
        count = 1;
    }

    public void addData(double data) {
        locker.writeLock().lock();

        sum += data;
        count++;

        locker.writeLock().unlock();
    }

    public double getAverage() {
        return count == 0 ? 0 : sum / count;
    }

    @Override
    public SensorData clone() {
        locker.readLock().lock();

        try {
            return new SensorData(sum, count);
        } finally {
            locker.readLock().unlock();
        }
    }
}
