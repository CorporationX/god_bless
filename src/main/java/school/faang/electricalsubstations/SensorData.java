package school.faang.electricalsubstations;

public class SensorData {
    private double sum = 0;
    private int count = 0;

    public synchronized void addData(double data) {
        sum += data;
        count++;
    }

    public synchronized double getAverage() {
        return sum / count;
    }
}
