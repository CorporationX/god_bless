package school.faang.sprint_4.task_51154;

public class SensorData {
    private volatile double sum;
    private volatile int count;

    public synchronized void addData(double data) {
        sum += data;
        count++;
    }

    public double getAverage() {
        return sum / count;
    }
}
