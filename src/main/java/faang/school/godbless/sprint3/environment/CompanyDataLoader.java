package faang.school.godbless.sprint3.environment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyDataLoader {
    CsvMapper mapper;
    CsvSchema schema;

    public CompanyDataLoader() {
        mapper = new CsvMapper();
        init();
    }

    private void init() {
        mapper.registerModule(new JavaTimeModule());
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        schema = mapper.schemaFor(EnvironmentalImpact.class)
                .withHeader()
                .withColumnSeparator(';');
    }

    public List<EnvironmentalImpact> load(String filepath) {
        List<EnvironmentalImpact> elements = new ArrayList<>();
        try {
            MappingIterator<EnvironmentalImpact> iterator = mapper
                    .readerFor(EnvironmentalImpact.class)
                    .with(schema)
                    .readValues(new FileReader(filepath));
            elements = iterator.readAll();
        } catch (IOException e) {
            log.error("Не получилось прочитать файл: " + e.getMessage());
        }
        return elements;
    }

    public void printInCsvFormat(EnvironmentalImpact impact) {
        String csv = null;
        try {
            csv = mapper.writer(schema.withUseHeader(true)).writeValueAsString(impact);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        System.out.println(csv);
    }
}
