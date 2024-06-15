package faang.school.godbless.stream.jobs;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Data
public class SalaryRangeInfo {

    private Map<SalaryRange, Integer> numberOfJobsBySalaryRange;

    public SalaryRangeInfo() {
        this.numberOfJobsBySalaryRange = new HashMap<>();
        this.numberOfJobsBySalaryRange.put(new SalaryRange(0.0, 50000.0), 0);
        this.numberOfJobsBySalaryRange.put(new SalaryRange(50000.0, 100000.0), 0);
        this.numberOfJobsBySalaryRange.put(new SalaryRange(100000.0, 150000.0), 0);
        this.numberOfJobsBySalaryRange.put(new SalaryRange(150000.0, 200000.0), 0);
        this.numberOfJobsBySalaryRange.put(new SalaryRange(200000.0, 250000.0), 0);
        this.numberOfJobsBySalaryRange.put(new SalaryRange(250000.0, 300000.0), 0);
        this.numberOfJobsBySalaryRange.put(new SalaryRange(300000.0, 350000.0), 0);
        this.numberOfJobsBySalaryRange.put(new SalaryRange(350000.0, 400000.0), 0);
        this.numberOfJobsBySalaryRange.put(new SalaryRange(400000.0, 450000.0), 0);
        this.numberOfJobsBySalaryRange.put(new SalaryRange(450000.0, 500000.0), 0);
    }

    public void appendStatistics(double salary) {
        this.numberOfJobsBySalaryRange
                .entrySet().stream()
                .filter(e -> salary >= e.getKey().lowerRange() && salary < e.getKey().upperRange())
                .forEach(e -> e.setValue(e.getValue() + 1));
    }

    public Map<SalaryRange, Integer> getNumberOfJobsBySalaryRange() {
        return Collections.unmodifiableMap(this.numberOfJobsBySalaryRange);
    }
}
