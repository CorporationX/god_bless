package school.faang.stream2.ecomonitoring;

import lombok.Data;
import org.apache.commons.csv.CSVRecord;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class EnvironmentalImpact {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    private final int id;
    private final int companyId;
    private final double volume;
    private final LocalDate date; //YYYY.MM.DD,
    private final PolutionType type;

    public static EnvironmentalImpact fromCsvRecord(CSVRecord record) {
        return new EnvironmentalImpact(
                Integer.parseInt(record.get("id")),
                Integer.parseInt(record.get("companyId")),
                Double.parseDouble(record.get("volume")),
                LocalDate.parse(record.get("date"), DATE_FORMATTER),
                PolutionType.valueOf(record.get("type").toUpperCase())
        );
    }
}
