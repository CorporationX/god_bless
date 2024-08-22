package faang.school.godbless.environmentalmonitoring;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CompanyDataLoader {
    public List<EnvironmentalImpact> loadEnvironmentalData(String fileName) {
        CsvMapper mapper = new CsvMapper();
        mapper.registerModule(new JavaTimeModule());
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        try (InputStream inputStream = getClass().getResourceAsStream("/" + fileName)) {
            MappingIterator<EnvironmentalImpact> iterator = mapper.readerFor(EnvironmentalImpact.class)
                    .with(schema)
                    .readValues(inputStream);

            return iterator.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read the file", e);
        }
    }
}