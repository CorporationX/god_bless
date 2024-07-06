package faang.school.godbless.substations;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@Setter
public class SensorData {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private int dataCount = 0;
    private double totalDataSum = 0;
    private double averageData = 0;

    public void addData(double data) {
        lock.writeLock().lock();
        try {
            totalDataSum += data;
            dataCount++;
            recalculateDataAverage();
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void recalculateDataAverage() {
        averageData = totalDataSum / dataCount;
    }

    public double getAverageData() {
        lock.readLock().lock();
        try {
            return averageData;
        } finally {
            lock.readLock().unlock();
        }
    }

    public double getSum() {
        lock.readLock().lock();
        try {
            return totalDataSum;
        } finally {
            lock.readLock().unlock();
        }
    }

    public int getCount() {
        lock.readLock().lock();
        try {
            return dataCount;
        } finally {
            lock.readLock().unlock();
        }
    }

    public void reset() {
        lock.writeLock().lock();
        try {
            totalDataSum = 0;
            dataCount = 0;
        } finally {
            lock.writeLock().unlock();
        }
    }
}
