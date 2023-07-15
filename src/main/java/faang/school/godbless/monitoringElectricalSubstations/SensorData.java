package faang.school.godbless.monitoringElectricalSubstations;

import lombok.Getter;

@Getter
public class SensorData {
    private double sum;
    private int count;

    public void addData(double data) {
        sum += data;
        count++;
    }

}
