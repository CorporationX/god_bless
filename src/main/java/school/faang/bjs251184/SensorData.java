package school.faang.bjs251184;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SensorData {

    private double sum;
    private int count;

    public synchronized void addData(double data) {
        if (data < 0) {
            log.error("Invalid input in addData");
            throw new IllegalArgumentException("Invalid input in addData");
        }
        sum += data;
        count++;
    }

    public synchronized double getAverage() {
        if (count == 0) {
            log.error("No data available");
            throw new IllegalStateException("No data available");
        }
        log.info("Average calculated: {}", sum / count);
        return sum / count;

    }
}
