package school.BJS2_39195;

public class SensorData {

    private double sum = 0;
    private int count;

    public synchronized void addData(double data) {
        sum += data;
        count++;
    }

    public synchronized double getAverage() {
        return count > 0 ? sum / count : 0;
    }
}
