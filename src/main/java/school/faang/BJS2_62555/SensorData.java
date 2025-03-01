package school.faang.BJS2_62555;

public class SensorData {
    private static final int OVERFLOW_LIMIT = 1_000_000;
    private double sum = 0;
    private int count = 0;
    private final Object lock = new Object();

    public void addData(double data) {
        if (Double.isNaN(data) || Double.isInfinite(data)) {
            return;
        }
        synchronized (lock) {
            sum += data;
            count++;
            if (sum > OVERFLOW_LIMIT) {
                sum = data;
                count = 1;
            }
        }
    }

    public double getAverage() {
        synchronized (lock) {
            return count == 0 ? 0.0 : sum / count;
        }
    }
}
