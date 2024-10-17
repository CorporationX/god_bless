package school.faang.BJS2_35028_EnvironmentalMonitoring;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

public class CompanyDataLoader {
    public <T> List<T> loadFromCsv(String filePath, Class<T> clazz) {
        try (FileReader reader = new FileReader(filePath)) {
            return new CsvToBeanBuilder<T>(reader)
                    .withType(clazz)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new UncheckedIOException(String.format("File not found: %s.", filePath), e);
        } catch (IOException e) {
            throw new UncheckedIOException(String.format("I/O error when reading a file: %s.", filePath), e);
        }
    }
}
