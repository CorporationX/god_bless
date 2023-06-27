package faang.school.godbless.sprint3.environment;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompanyDataLoaderTest {
    private CompanyDataLoader loader;


    @BeforeEach
    void setUp() {
        loader = new CompanyDataLoader();
    }

    @Test
    void load() {
        List<EnvironmentalImpact> elements = loader.load(
                "src/main/java/faang/school/godbless/sprint3/environment/file.csv"
        );

        EnvironmentalImpact expected = new EnvironmentalImpact(
                1,
                "company1",
                10000.0,
                LocalDate.parse("2023-01-10"),
                EnvironmentalImpact.Type.ENERGY_CONSUMPTION
        );

        System.out.println(elements);

        assertEquals(expected, elements.get(0));
    }
}