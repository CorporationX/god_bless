package school.faang.electrical_monitoring_BJS2_39147;

public class SensorData {
    private double sum = 0.0;
    private int count = 0;

    public synchronized void addData(double value) {
        sum += value;
        count++;
    }

    public synchronized double getAverage() {
        return sum / count;
    }
}