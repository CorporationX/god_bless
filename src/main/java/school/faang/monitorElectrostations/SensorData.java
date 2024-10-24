package school.faang.monitorElectrostations;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SensorData {
    private double sum;
    private int count;

    public synchronized void addData(double data) {
        sum += data;
        count++;
    }

    public synchronized double getAverage() {
        return count > 0 ? sum / count : 0;
    }
}
