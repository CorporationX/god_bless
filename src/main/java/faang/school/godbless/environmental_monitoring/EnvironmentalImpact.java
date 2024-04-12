package faang.school.godbless.environmental_monitoring;

import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentalImpact {
    private int id;
    private int companyId;
    private double volume;
    @CsvDate("yyyy.MM.dd")
    private LocalDate date;
    private EnvironmentalImpactType type;
}