package school.faang.bjs2_70755;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;


@NoArgsConstructor
@Slf4j
public class CompanyDataLoader {
    public List<EnvironmentalImpact> readDataFromScv(String fileName) {
        List<EnvironmentalImpact> impacts;

        try (Reader myReader = getReader(fileName)) {

            CsvMapper mapper = new CsvMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            CsvSchema schema = mapper.schemaFor(EnvironmentalImpact.class)
                    .withColumnSeparator(',').withSkipFirstDataRow(true);

            MappingIterator<EnvironmentalImpact> iterator = mapper
                    .readerFor(EnvironmentalImpact.class)
                    .with(schema)
                    .readValues(myReader);

            impacts = iterator.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить файл: " + fileName, e);
        }
        return impacts;
    }

    private Reader getReader(String fileName) {
        return new InputStreamReader(Objects.requireNonNull(
                getClass().getClassLoader().getResourceAsStream(fileName)));
    }
}
