package school.faang.BJS2_35028_EnvironmentalMonitoring;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentalImpact {
    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "companyId")
    private int companyId;

    @CsvBindByName(column = "volume")
    private double volume;

    @CsvBindByName(column = "date")
    @CsvDate("yyyy.MM.dd")
    private LocalDate date;

    @CsvBindByName(column = "type")
    private String type;
}
