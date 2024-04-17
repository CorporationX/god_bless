package faang.school.godbless.streamAPI.jobs;

import java.time.LocalDateTime;
import java.util.List;

public record Job (String positionName,
                   List<String> requirements,
                   int salary,
                   String location,
                   LocalDateTime creationDate) {

    @Override
    public String toString() {
        return "Job{" +
                "\npositionName='" + positionName + '\'' +
                ", \nrequirements=" + requirements +
                ", \nsalary=" + salary +
                ", \nlocation='" + location + '\'' +
                ", \ncreationDate=" + creationDate +
                '}';
    }
}
