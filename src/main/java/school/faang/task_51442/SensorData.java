package school.faang.task_51442;

public class SensorData {
    private double sum = 0;
    private int count = 0;

    public synchronized void addData(double data) {
        sum += data;
        count++;
    }

    public synchronized double getSum() {
        return sum;
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized double getAverage() {
        return count > 0 ? sum / count : 0;
    }
}

