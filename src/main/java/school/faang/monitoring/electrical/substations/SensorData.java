package school.faang.monitoring.electrical.substations;

public record SensorData(double sum, int count) {

    public double getAverage() {
        if (count == 0) return 0;
        return sum / count;
    }

    public static SensorData merge(SensorData data1, SensorData data2) {
        return new SensorData(data1.sum() + data2.sum(), data1.count() + data2.count());
    }
}
