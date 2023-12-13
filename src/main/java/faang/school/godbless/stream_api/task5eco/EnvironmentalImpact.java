package faang.school.godbless.stream_api.task5eco;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private double volume;
    private Date date;
    private ImpactType type;
}
