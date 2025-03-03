package school.faang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SensorData {
    private double sum;
    private int count;

    public void addData(double data) {
        sum += data;
        count++;
    }

    public double getAverage() {
        return sum / count;
    }
}
