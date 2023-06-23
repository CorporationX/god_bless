package faang.school.godbless.sprint3.streamAPI.task5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EnvironmentalImpact {

    private int id;

    private int companyId;

    private double volume;

    private LocalDate date;

    private Type type;
}
