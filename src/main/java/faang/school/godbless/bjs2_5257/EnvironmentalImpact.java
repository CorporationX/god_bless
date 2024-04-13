package faang.school.godbless.bjs2_5257;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class EnvironmentalImpact {

    @CsvBindByPosition(position = 0)
    private int id;

    @CsvBindByPosition(position = 1)
    private int companyId;

    @CsvBindByPosition(position = 2)
    private double volume;

    @CsvDate(value = "yyyy.MM.dd")
    @CsvBindByPosition(position = 3)
    private LocalDate date;

    @CsvBindByPosition(position = 4)
    private TypeImpact type;
}
