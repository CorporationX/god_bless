package school.faang.task426.sensor;

public class SensorData {
    private double sum = 0;
    private int count = 0;

    public void addData(double data) {
        sum += data;
        count++;
    }

    public double getAverage() {
        return sum > 0 ? sum / count : 0;
    }
}
