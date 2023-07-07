package faang.school.godbless.ElectricalSubstations;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SensorData {
    private List<Double> dataList;

    public SensorData() {
        this.dataList = new ArrayList<>();
    }

    public synchronized void addData(double data) {
        dataList.add(data);
    }

    public synchronized double average() {
        return dataList.stream()
                .mapToDouble(e -> e)
                .average()
                .getAsDouble();
    }
}
