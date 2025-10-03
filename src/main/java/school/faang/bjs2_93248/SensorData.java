package school.faang.bjs2_93248;

public class SensorData {
    private double sum;
    private int count;

    public void addData(double data) {
        synchronized (this) {
            sum += data;
            count++;
        }
    }

    public double getAverage() {
        synchronized (this) {
            return count == 0 ? 0.0 : sum / count;
        }
    }
}