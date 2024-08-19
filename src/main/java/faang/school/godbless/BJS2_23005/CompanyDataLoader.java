package faang.school.godbless.BJS2_23005;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
public class CompanyDataLoader {

    private static CsvMapper csvMapper;
    private static CsvSchema csvSchema;

    static {
        csvMapper = new CsvMapper();
        csvMapper.registerModule(new JavaTimeModule());

        csvSchema = CsvSchema.builder()
                .addColumn("id")
                .addColumn("company.id")
                .addColumn("company.name")
                .addColumn("company.totalEmployees")
                .addColumn("volume")
                .addColumn("date")
                .addColumn("factor")
                .build()
                .withHeader();
    }

    public static Optional<List<EnvironmentalImpact>> parseCsvToEnvironmentalImpact(File file) {
        try (MappingIterator<EnvironmentalImpact> readValues = csvMapper
                .readerFor(EnvironmentalImpact.class)
                .with(csvSchema)
                .readValues(file)) {
            return Optional.ofNullable(readValues.readAll());

        } catch (IOException e) {
            log.info(e.getMessage());
            return Optional.empty();
        }
    }
}
